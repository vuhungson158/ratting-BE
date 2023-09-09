package kiis.ratingBE.security;

import kiis.ratingBE.features.user.UserEntity;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/auth")
public class AuthController {
    private final AuthService authService;

    /**
     * @param loginRequest username + password
     * @return jwt Token
     */
    @PostMapping("/login")
    public String login(@RequestBody @NotNull UserEntity.LoginForm loginRequest) {
        return authService.login(loginRequest);
    }
}
