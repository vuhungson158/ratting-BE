package kiis.ratingBE.common;

import com.cosium.spring.data.jpa.entity.graph.domain2.EntityGraph;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

/**
 * Every Entity's ID is Long type
 *
 * @see BaseEntity#id
 */
@NoRepositoryBean
public interface CommonRepository<T extends BaseEntity> extends
        EntityGraphJpaRepository<T, Long> {

    /**
     * same with findAll(), but where 'isDeleted' = false
     *
     * @see JpaRepository#findAll()
     */
    List<T> findAllByIsDeletedIsFalse();

    /**
     * same with findAll(Pageable), but where 'isDeleted' = false
     *
     * @see EntityGraphJpaRepository#findAll(Pageable)
     */
    Page<T> findAllByIsDeletedIsFalse(Pageable pageable);

    /**
     * same with findAll(Pageable, EntityGraph), but where 'isDeleted' = false
     *
     * @see EntityGraphJpaRepository#findAll(Pageable, EntityGraph)
     */
    Page<T> findAllByIsDeletedIsFalse(Pageable pageable, EntityGraph entityGraph);
}
