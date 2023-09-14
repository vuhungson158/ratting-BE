package kiis.ratingBE.features.teacher.base;

import kiis.ratingBE.common.CommonRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends
        CommonRepository<TeacherEntity> {
}