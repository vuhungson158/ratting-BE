package kiis.ratingBE.features.comment.base;

import kiis.ratingBE.common.SimpleCurdRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends
        SimpleCurdRepository<CommentEntity> {
}
