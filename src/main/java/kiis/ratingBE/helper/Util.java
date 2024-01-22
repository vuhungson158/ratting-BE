package kiis.ratingBE.helper;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public abstract class Util {
    /**
     * @param beanClass class want to use
     * @param beanList  list of implementation of an interface
     * @param <T>       return type
     * @param <U>       interface
     * @return bean
     */
    @Deprecated
    public static <T extends U, U> @NotNull U chooseBeanFromList(@NotNull Class<T> beanClass, @NotNull List<U> beanList) {
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
}
