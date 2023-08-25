package kiis.ratingBE.helper;

import kiis.edu.rating.security.JwtTokenVerifier;
import kiis.edu.rating.security.SpringSecurityAuditorAware;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableJpaAuditing()
public class Beans {
    @Bean
    public AuditorAware<String> auditorAware() {
        return new SpringSecurityAuditorAware();
    }

    @Contract(" -> new")
    @Bean
    public static @NotNull JwtTokenVerifier jwtTokenVerifier() {
        return new JwtTokenVerifier();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }
}
