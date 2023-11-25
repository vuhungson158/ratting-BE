package kiis.ratingBE.features.auth;

import io.jsonwebtoken.Jwts;
import kiis.ratingBE.exception.LoginException;
import kiis.ratingBE.exception.RecordNotFoundException;
import kiis.ratingBE.features.user.UserEntity;
import kiis.ratingBE.features.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.Date;

import static kiis.ratingBE.helper.Constant.CLAIM_AUTHORITY;
import static kiis.ratingBE.helper.Constant.ENCODED_SECRET_KEY;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;

    public TokenBearer login(@RequestBody @NotNull UserEntity.LoginForm loginRequest) {
        final UserEntity userEntity = userRepository
                .findByEmail(loginRequest.email())
                .orElseThrow(() -> new LoginException("Email is not correct"));

        if (!userEntity.password.equals(loginRequest.password()))
            throw new LoginException("Password is not correct");

        final String token = Jwts.builder()
                .setId(String.valueOf(userEntity.id))
                .setSubject(userEntity.email)
                .claim(CLAIM_AUTHORITY, userEntity.role)
                .setIssuedAt(new Date())
                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(1)))
                .signWith(ENCODED_SECRET_KEY)
                .compact();
        return new TokenBearer(token);
    }

    public UserEntity resign(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    public Long getLongingUserId() {
        final String userEmail = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        final UserEntity userEntity = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RecordNotFoundException("user"));
        return userEntity.id;
    }
}
