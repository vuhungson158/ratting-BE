package kiis.ratingBE.features.teacher.comment;

import kiis.ratingBE.common.comment.CommentReactRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherCommentReactRepository extends CommentReactRepository<TeacherCommentReactEntity> {
}
