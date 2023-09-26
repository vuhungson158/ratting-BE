package kiis.ratingBE.features.comment.base.service;

import kiis.ratingBE.features.comment.base.CommentEntity;
import org.springframework.data.domain.Page;

public interface CommentService {

    boolean useCase(CommentServiceImplementation implementation);

    Page<CommentEntity> findPage(long id, int page, int limit);
}
