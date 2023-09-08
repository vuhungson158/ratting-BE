package kiis.ratingBE.features.teacher.base;

import kiis.ratingBE.common.SimpleCurdRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends
        SimpleCurdRepository<TeacherEntity> {
}