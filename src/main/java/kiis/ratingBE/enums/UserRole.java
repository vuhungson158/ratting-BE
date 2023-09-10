package kiis.ratingBE.enums;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static kiis.ratingBE.enums.UserRole.Feature.SUBJECT;
import static kiis.ratingBE.enums.UserRole.Feature.SUBJECT_COMMENT;
import static kiis.ratingBE.enums.UserRole.Feature.SUBJECT_RATING;
import static kiis.ratingBE.enums.UserRole.Feature.TEACHER;
import static kiis.ratingBE.enums.UserRole.Feature.TEACHER_COMMENT;
import static kiis.ratingBE.enums.UserRole.Feature.altogether;
import static kiis.ratingBE.enums.UserRole.Method.CREATE;
import static kiis.ratingBE.enums.UserRole.Method.DELETE;
import static kiis.ratingBE.enums.UserRole.Method.FIND_ALL;
import static kiis.ratingBE.enums.UserRole.Method.FIND_BY_ID;
import static kiis.ratingBE.enums.UserRole.Method.UPDATE;

public enum UserRole {
    ADMIN(altogether()),
    MANAGER(
            SUBJECT.all(),
            SUBJECT_RATING.all(),
            SUBJECT_COMMENT.all()
    ),
    USER(
            TEACHER.methods(FIND_ALL, CREATE),
            TEACHER_COMMENT.methods(UPDATE, DELETE)
    ),
    ANONYMOUS(
            SUBJECT.methods(FIND_BY_ID, FIND_ALL),
            TEACHER.methods(FIND_BY_ID, FIND_ALL)
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
            Arrays.stream(values()).forEach(feature -> result.addAll(feature.all()));
            return result;
        }
    }

}