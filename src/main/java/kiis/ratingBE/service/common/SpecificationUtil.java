package kiis.ratingBE.service.common;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.Contract;
import org.springframework.data.jpa.domain.Specification;

@RequiredArgsConstructor
public class SpecificationUtil<T> {
    private final String column;

    @Contract(pure = true)
    public Specification<T> between(Integer min, Integer max) {
        if (min != null && max != null) {
            return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get(column), min, max);
        }
        if (min != null) return greater(min);
        if (max != null) return smaller(max);
        return null;
    }

    @Contract(pure = true)
    public Specification<T> smaller(Integer max) {
        return max == null ? null : (root, query, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get(column), max);
    }

    @Contract(pure = true)
    public Specification<T> greater(Integer min) {
        return min == null ? null : (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get(column), min);
    }

    @Contract(pure = true)
    public Specification<T> include(String included) {
        return included == null ? null : (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get(column), "%" + included + "%");
    }

    @Contract(pure = true)
    public Specification<T> is(Enum<?> anEnum) {
        return anEnum == null ? null : (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get(column), anEnum);
    }

    @Contract(pure = true)
    public Specification<T> is(Boolean aBoolean) {
        return aBoolean == null ? null : (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get(column), aBoolean);
    }
}
