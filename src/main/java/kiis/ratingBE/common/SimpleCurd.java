package kiis.ratingBE.common;

import org.springframework.data.domain.Page;

public interface SimpleCurd<T extends BaseEntity> {

    T findById(long id);

    Page<T> findAll(int page, int limit);

    Page<T> findAll(T exampleEntity, int page, int limit);

    T create(T entity);

    T update(T entity, long id);

    T delete(long id);
}
