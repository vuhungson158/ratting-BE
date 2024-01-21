package kiis.ratingBE.repository.teacher;

import kiis.ratingBE.model.teacher.TeacherJoinEntity;
import kiis.ratingBE.repository.common.JoinRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherJoinRepository extends JoinRepository<TeacherJoinEntity> {
}