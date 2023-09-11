package kiis.ratingBE.features.teacher.base;

import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface TeacherEndpoint {
    /**
     * @return not pagination List
     */
    List<TeacherEntity> findAll();

    /**
     * @return a {@link TeacherEntity} join {@link TeacherEntity#subjects}
     */
    TeacherEntity findOneJoinSubject(@PathVariable long id);
}
