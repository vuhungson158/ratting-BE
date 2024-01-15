package kiis.ratingBE.common.join;

import kiis.ratingBE.model.BaseEntity;
import org.springframework.data.domain.Page;

public interface Join<Entity extends BaseEntity> {
    Entity findByIdJoin(long id);

    Page<Entity> findAllJoin(int page, int limit);

    Page<Entity> findAllJoin(Entity exampleEntity, int page, int limit);
}
