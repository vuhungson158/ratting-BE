package kiis.ratingBE.service.common;

import com.cosium.spring.data.jpa.entity.graph.domain2.EntityGraph;
import kiis.ratingBE.model.common.BaseEntity;
import kiis.ratingBE.model.common.JoinEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface JoinService<Entity extends BaseEntity & JoinEntity> {
    Entity findById(long id, EntityGraph joins);

    Page<Entity> findAll(Pageable paging, EntityGraph joins);

    Page<Entity> findAll(Example<Entity> filter, Pageable paging, EntityGraph joins);

    Page<Entity> findAll(Specification<Entity> filter, Pageable paging, EntityGraph joins);
}
