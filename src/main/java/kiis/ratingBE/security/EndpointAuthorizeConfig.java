package kiis.ratingBE.security;

import kiis.ratingBE.enums.UserRole;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.stereotype.Component;

@Component
public class EndpointAuthorizeConfig
        implements Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry> {
    @Override
    public void customize(AuthorizeHttpRequestsConfigurer<HttpSecurity>
                                  .@NotNull AuthorizationManagerRequestMatcherRegistry authorizationManagerRequestMatcherRegistry) {
        final String ADMIN = UserRole.ADMIN.name();
        final String USER = UserRole.USER.name();
//        final String MANAGER = UserRole.MANAGER.name();

        authorizationManagerRequestMatcherRegistry

                // Teacher endpoints
//                .requestMatchers(GET, "/teacher/{id}").hasAnyRole(ADMIN, USER)

                // Subject
//                .requestMatchers(GET, "/subject/{id}").hasAnyRole(ADMIN, USER)

                .anyRequest().permitAll();
    }
}
