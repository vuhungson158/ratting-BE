package kiis.ratingBE.aop;


import kiis.ratingBE.enums.UserRole;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class AOPHandler {

    @Deprecated
    @Before(value = "@target(allowFeature) && @annotation(allowMethod)", argNames = "allowFeature,allowMethod")
    public void featureMethodPointcut(AllowFeature allowFeature, AllowMethod allowMethod) {
        permissionCheck(allowFeature.value().concat(allowMethod.value()));
    }

    @Deprecated
    @Before("@annotation(allowPermission)")
    public void permissionPointcut(AllowPermission allowPermission) {
        permissionCheck(allowPermission.feature().concat(allowPermission.method()));
    }

    @Before("@annotation(allowRoles)")
    public void rolePointcut(@NotNull AllowRoles allowRoles) {
        final SecurityExpressionRoot securityExpressionRoot = getSecurityExpressionRoot();

        final String[] roles = mapToString(allowRoles.value());
        if (!securityExpressionRoot.hasAnyRole(roles)) {
            throw new AccessDeniedException("You need user role: " + Arrays.toString(roles) + " to call this api");
        }
    }

    private void permissionCheck(String authority) {
        final SecurityExpressionRoot securityExpressionRoot = getSecurityExpressionRoot();
        if (!securityExpressionRoot.hasAuthority(authority)) {
            throw new AccessDeniedException("You need authority: " + authority + " to call this api");
        }
    }

    private @NotNull SecurityExpressionRoot getSecurityExpressionRoot() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return new SecurityExpressionRoot(authentication) {
        };
    }

    @Contract(pure = true)
    private String @NotNull [] mapToString(UserRole @NotNull [] roles) {
        final String[] result = new String[roles.length];
        for (int i = 0; i < roles.length; i++) {
            final UserRole role = roles[i];
            result[i] = role.name();
        }
        return result;
    }
}
