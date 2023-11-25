package kiis.ratingBE.security;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.ExceptionHandlingConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {
    private final JwtTokenVerifier jwtTokenVerifier;
    private final EndpointAuthorizeConfig endpointAuthorizeConfig;
    private final Environment environment;

    @Bean
    protected SecurityFilterChain securityFilterChain(@NotNull HttpSecurity http) throws Exception {
        http
                .cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtTokenVerifier, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(endpointAuthorizeConfig)
                .exceptionHandling(exceptionHandlingCustomizer());
        return http.build();
    }

    @Contract(pure = true)
    private @NotNull Customizer<ExceptionHandlingConfigurer<HttpSecurity>> exceptionHandlingCustomizer() {
        return configurer -> configurer
                .accessDeniedHandler((request, response, accessDeniedException) -> {
                    final String contextPath = environment.getProperty("server.servlet.context-path");
                    response.sendRedirect(contextPath + "/auth/access-denied");
                });
    }

//    @Bean
//    public Filter corsFilter() {
//        return (servletRequest, servletResponse, filterChain) -> {
//
//            final HttpServletRequest request = (HttpServletRequest) servletRequest;
//            final HttpServletResponse response = (HttpServletResponse) servletResponse;
//
//            response.setHeader("Access-Control-Allow-Origin", "*");
//            response.setHeader("Access-Control-Allow-Headers", "Authorization, *");
//            response.setHeader("Access-Control-Allow-Methods", "*");
//
//            filterChain.doFilter(request, response);
//        };
//    }
}
