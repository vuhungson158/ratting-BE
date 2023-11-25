package kiis.ratingBE.features.subject.comment;

import kiis.ratingBE.common.comment.CommentRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectCommentRepository extends CommentRepository<SubjectCommentEntity> {
}
