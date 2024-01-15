package kiis.ratingBE.common.comment;

import kiis.ratingBE.repository.CommonRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface CommentReactRepository<CommentReactEntity extends ReactBaseEntity<? extends CommentBaseEntity>>
        extends CommonRepository<CommentReactEntity> {

    Optional<CommentReactEntity> findByCommentIdAndUserId(long commentId, long userId);
}
