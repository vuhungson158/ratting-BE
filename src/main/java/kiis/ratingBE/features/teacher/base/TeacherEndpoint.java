package kiis.ratingBE.features.teacher.base;

import java.util.List;

public interface TeacherEndpoint {
    /**
     * @return not pagination List
     */
    List<TeacherEntity> findAll();
}
