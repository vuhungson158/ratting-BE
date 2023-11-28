package kiis.ratingBE.common.comment;

import kiis.ratingBE.common.CommonRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface CommentRepository<CommentEntity extends CommentBaseEntity>
        extends CommonRepository<CommentEntity> {

    List<CommentEntity> findPageBy(long parentId, int page, int limit);

    long countBy(long parentId);
}
