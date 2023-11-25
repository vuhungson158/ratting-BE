package kiis.ratingBE.features.subject.comment;

import kiis.ratingBE.common.comment.CommentReactRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectCommentReactRepository extends CommentReactRepository<SubjectCommentReactEntity> {
}
