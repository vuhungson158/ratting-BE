package kiis.ratingBE.service.common;

import kiis.ratingBE.model.common.BaseEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface JoinService<Entity extends BaseEntity> {
    Entity findById(long id);

    Page<Entity> findAll(Pageable paging);

    Page<Entity> findAll(Example<Entity> filter, Pageable paging);

    Page<Entity> findAll(Specification<Entity> filter, Pageable paging);
}
