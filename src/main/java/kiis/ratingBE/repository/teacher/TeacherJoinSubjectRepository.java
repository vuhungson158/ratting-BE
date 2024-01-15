package kiis.ratingBE.repository.teacher;

import kiis.ratingBE.model.teacher.TeacherJoinSubjectEntity;
import kiis.ratingBE.repository.JoinRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherJoinSubjectRepository extends JoinRepository<TeacherJoinSubjectEntity> {
}