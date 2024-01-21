package kiis.ratingBE.repository.subject;

import kiis.ratingBE.model.subject.SubjectJoinTeacherEntity;
import kiis.ratingBE.repository.common.JoinRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectJoinTeacherRepository extends JoinRepository<SubjectJoinTeacherEntity> {
}


