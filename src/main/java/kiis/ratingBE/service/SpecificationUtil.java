package kiis.ratingBE.service;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.domain.Specification;

@RequiredArgsConstructor
public abstract class SpecificationUtil<T> {
    private final String column;

    @Contract(pure = true)
    public @NotNull Specification<T> between(int min, int max) {
        return (root, query, criteriaBuilder) -> criteriaBuilder
                .between(root.get(column), min, max);
    }

    @Contract(pure = true)
    public @NotNull Specification<T> include(String included) {
        return (root, query, criteriaBuilder) -> criteriaBuilder
                .like(root.get(column), "%" + included + "%");
    }
}
