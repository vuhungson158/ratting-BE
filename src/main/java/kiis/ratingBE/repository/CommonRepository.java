package kiis.ratingBE.repository;

import kiis.ratingBE.model.BaseEntity;
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
public interface CommonRepository<T extends BaseEntity>
        extends JpaRepository<T, Long> {

    /**
     * same with findAll(), but where 'isDeleted' = false
     *
     * @see JpaRepository#findAll()
     */
    List<T> findAllByIsDeletedIsFalse();

    /**
     * same with findAll(Pageable), but where 'isDeleted' = false
     *
     * @see JpaRepository#findAll(Pageable)
     */
    Page<T> findAllByIsDeletedIsFalse(Pageable pageable);
}
