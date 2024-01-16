package kiis.ratingBE.service;

import kiis.ratingBE.model.BaseEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CrudService<Entity extends BaseEntity> {
    Entity findById(long id);

    Page<Entity> findAll(Pageable paging);

    Page<Entity> findAll(Example<Entity> filter, Pageable paging);

    Entity create(Entity entity);

    Entity update(Entity entity, long id);

    Entity delete(long id);
}
