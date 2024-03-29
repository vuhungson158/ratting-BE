package kiis.ratingBE.repository.common;

import com.cosium.spring.data.jpa.entity.graph.domain2.EntityGraph;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaSpecificationExecutor;
import kiis.ratingBE.model.common.BaseEntity;
import kiis.ratingBE.model.common.JoinEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Every Entity's ID is Long type
 *
 * @see BaseEntity#id
 */
@NoRepositoryBean
public interface JoinRepository<T extends BaseEntity & JoinEntity>
        extends EntityGraphJpaRepository<T, Long>, EntityGraphJpaSpecificationExecutor<T> {

    /**
     * same with findAll(Pageable, EntityGraph), but where 'isDeleted' = false
     *
     * @see EntityGraphJpaRepository#findAll(Pageable, EntityGraph)
     */
    Page<T> findAllByIsDeletedIsFalse(Pageable pageable, EntityGraph entityGraph);
}
