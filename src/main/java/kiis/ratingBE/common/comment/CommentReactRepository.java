package kiis.ratingBE.common.comment;

import kiis.ratingBE.common.CommonRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CommentReactRepository<CommentReactEntity extends ReactBaseEntity<? extends CommentBaseEntity>>
        extends CommonRepository<CommentReactEntity> {
}
