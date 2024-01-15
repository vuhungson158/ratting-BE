package kiis.ratingBE.service;

import kiis.ratingBE.model.BaseEntity;
import org.springframework.data.domain.Page;

public interface JoinService<Entity extends BaseEntity> {
    Entity findById(long id);

    Page<Entity> findAll(int page, int limit);

    Page<Entity> findAll(Entity exampleEntity, int page, int limit);
}
