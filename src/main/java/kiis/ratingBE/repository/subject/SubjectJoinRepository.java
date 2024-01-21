package kiis.ratingBE.repository.subject;

import kiis.ratingBE.model.subject.SubjectJoinEntity;
import kiis.ratingBE.repository.common.JoinRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectJoinRepository extends JoinRepository<SubjectJoinEntity> {
}


