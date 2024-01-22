package kiis.ratingBE.helper;

import kiis.ratingBE.model.common.BaseEntity;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.lang.reflect.Field;
import java.util.List;
import java.util.function.Function;

public abstract class MappingUtil {
    final static Logger logger = LoggerFactory.getLogger(Util.class);

    public static <T extends BaseEntity> void copyBaseEntityProperties(@NotNull T source, @NotNull T target) {
        copyProperties(source, target, BaseEntity.class);
    }

    /**
     * (S-source) and (T-target) must be inherited same (C-super)
     *
     * @param baseModel only copy properties that declared in {@code Class<C>}
     * @param <C>       super class
     * @param <S>       source
     * @param <T>       target
     */
    public static <C, S extends C, T extends C> void copyProperties(@NotNull S source, @NotNull T target, @NotNull Class<C> baseModel) {
        for (final Field field : baseModel.getDeclaredFields()) {
            try {
                final Object sourceValue = field.get(source);
                field.set(target, sourceValue);
            } catch (final IllegalAccessException e) {
                logger.error(e.getMessage(), e);
                return;
            }
        }
    }

    /**
     * input page(P-param) and output page(R-return) must be inherited same (S-super)
     */
    public static <S, P extends S, R extends S> @NotNull Page<R> mappingPage(@NotNull Page<P> page, Function<P, R> mapper) {
        final List<R> list = page.getContent().stream()
                .map(mapper)
                .toList();
        return new PageImpl<>(list, page.getPageable(), page.getTotalElements());
    }
}
