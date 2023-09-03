package kiis.ratingBE.features.teacher.base;

import kiis.ratingBE.helper.Util;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public class TeacherDto extends TeacherEntity {
    @Contract(pure = true)
    public static @NotNull Function<TeacherEntity, TeacherDto> mapper() {
        return entity -> Util.mapping(entity, TeacherDto.class);
    }
}
