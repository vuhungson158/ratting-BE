package kiis.ratingBE.controller;

import kiis.ratingBE.model.user.UserEntity;
import kiis.ratingBE.model.user.TokenBearer;
import kiis.ratingBE.service.user.AuthService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.GetMapping;
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
    public TokenBearer login(@RequestBody @NotNull UserEntity.LoginForm loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/resign")
    public UserEntity resign(@RequestBody @NotNull UserEntity userEntity) {
        return authService.resign(userEntity);
    }

    @GetMapping("/access-denied")
    public void accessDenied() {
        throw new AccessDeniedException("Your Role doesn't have permission to call this api");
    }
}
