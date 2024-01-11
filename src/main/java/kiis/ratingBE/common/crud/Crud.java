package kiis.ratingBE.common.crud;

import kiis.ratingBE.common.BaseEntity;
import org.springframework.data.domain.Page;

public interface Crud<Entity extends BaseEntity> {
    Entity findById(long id);

    Page<Entity> findAll(int page, int limit);

    Page<Entity> findAll(Entity exampleEntity, int page, int limit);

    Entity create(Entity entity);

    Entity update(Entity entity, long id);

    Entity delete(long id);
}
