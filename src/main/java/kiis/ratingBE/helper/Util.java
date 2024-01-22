package kiis.ratingBE.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import kiis.ratingBE.model.common.BaseEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public abstract class Util {
    final static ObjectMapper mapper = new ObjectMapper();
    final static Logger logger = LoggerFactory.getLogger(Util.class);

    static {
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * @param object source
     * @param type   target Class
     * @param <T>    target Class Type
     * @return target with source's properties
     */
    public static <T> @Nullable T mapping(Object object, Class<T> type) {
        try {
            return mapper.readValue(mapper.writeValueAsString(object), type);
        } catch (final JsonProcessingException e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    /**
     * @param beanClass class want to use
     * @param beanList  list of implementation of an interface
     * @param <T>       return type
     * @param <U>       interface
     * @return bean
     */
    @Deprecated
    public static <T extends U, U> @NotNull U chooseBeanFromList(@NotNull Class<T> beanClass,
                                                                 @NotNull List<U> beanList) {
        for (final U bean : beanList) {
            if (Objects.equals(bean.getClass(), beanClass)) {
                return bean;
            }
        }
        throw new AbstractMethodError();
    }

    public static @NotNull Integer calculateAge(@NotNull Date dob) {
        final LocalDate localDateDob = dob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return Period.between(localDateDob, LocalDate.now()).getYears();
    }

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
