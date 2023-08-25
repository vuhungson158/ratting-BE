package kiis.ratingBE.enums;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public enum UserRole {
    ADMIN(Feature.altogether()),
    MANAGER(
            Feature.SUBJECT.all(),
            Feature.SUBJECT_RATING.all(),
            Feature.SUBJECT_COMMENT.all()
    ),
    USER(
            Feature.TEACHER.methods(Method.FIND_ALL, Method.CREATE),
            Feature.TEACHER_COMMENT.methods(Method.UPDATE, Method.DELETE)
    );

    public final Set<String> authorities;

    @SafeVarargs
    UserRole(Set<Combinator>... sets) {
        final Set<String> userAuthorities = new HashSet<>();
        Arrays.stream(sets).forEach(combinators -> userAuthorities.addAll(
                combinators.stream()
                        .map(Combinator::concat)
                        .collect(Collectors.toSet())
        ));
        this.authorities = userAuthorities;
    }

    public @NotNull Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        final Set<SimpleGrantedAuthority> permissions = this.authorities.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }

    public enum Method {
        FIND_ALL, FIND_ENABLED, FIND_BY_ID, FIND_BY_PAGEABLE, FIND_BY_FILTER, CREATE, UPDATE, DELETE, FORCE_DELETE
    }

    public enum Feature {
        SUBJECT, SUBJECT_RATING, SUBJECT_COMMENT, SUBJECT_COMMENT_REACT,
        TEACHER, TEACHER_RATING, TEACHER_COMMENT, TEACHER_COMMENT_REACT,
        FILE, OTHER;

        @Contract("_ -> new")
        private @NotNull Combinator combinator(Method method) {
            return new Combinator(this, method);
        }

        public String concat(Method method) {
            return combinator(method).concat();
        }

        public Set<Combinator> methods(Method... methods) {
            return Arrays.stream(methods)
                    .map(method -> new Combinator(this, method))
                    .collect(Collectors.toSet());
        }

        public Set<Combinator> all() {
            return methods(Method.values());
        }

        public static @NotNull Set<Combinator> altogether() {
            final Set<Combinator> result = new HashSet<>();
            Arrays.stream(Feature.values()).forEach(feature -> result.addAll(feature.all()));
            return result;
        }
    }

}