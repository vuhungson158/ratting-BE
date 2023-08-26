package kiis.ratingBE.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kiis.ratingBE.enums.UserRole;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Set;

import static kiis.ratingBE.helper.Constant.BEARER;
import static kiis.ratingBE.helper.Constant.CLAIM_AUTHORITY;
import static kiis.ratingBE.helper.Constant.ENCODED_SECRET_KEY;
import static kiis.ratingBE.helper.Constant.LOGGER;
import static kiis.ratingBE.helper.Constant.TOKEN_HEADER;

@Component
public class JwtTokenVerifier extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(@NotNull HttpServletRequest request,
                                    @NotNull HttpServletResponse response,
                                    @NotNull FilterChain filterChain)
            throws ServletException, IOException {
        final String authorizationHeader = request.getHeader(TOKEN_HEADER);
        if (authorizationHeader == null || !authorizationHeader.startsWith(BEARER)) {
            filterChain.doFilter(request, response);
            return;
        }

        try {
            final String token = authorizationHeader.replace(BEARER, "");
            final Claims claimsJwsBody = Jwts.parserBuilder()
                    .setSigningKey(ENCODED_SECRET_KEY)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            final String username = claimsJwsBody.getSubject();
            final UserRole role = UserRole.valueOf((String) claimsJwsBody.get(CLAIM_AUTHORITY));
            final Set<SimpleGrantedAuthority> simpleGrantedAuthorities = role.getGrantedAuthorities();

            final Authentication authentication =
                    new UsernamePasswordAuthenticationToken(username, null, simpleGrantedAuthorities);
            SecurityContextHolder.getContext().setAuthentication(authentication);

        } catch (final JwtException e) {
            LOGGER.error("Token cannot be trust");
        }

        filterChain.doFilter(request, response);
    }
}
