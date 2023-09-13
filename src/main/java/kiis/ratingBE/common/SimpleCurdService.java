package kiis.ratingBE.common;

import com.cosium.spring.data.jpa.entity.graph.domain2.DynamicEntityGraph;
import com.cosium.spring.data.jpa.entity.graph.domain2.EntityGraph;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import kiis.ratingBE.exception.RecordNotFoundException;
import kiis.ratingBE.exception.VersionException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public abstract class SimpleCurdService<T extends BaseEntity>
        implements SimpleCurd<T> {

    private final SimpleCurdRepository<T> mainRepository;

    @Override
    public T findById(long id) {
        return mainRepository.findById(id, entityGraphOf(findByIdJoin()))
                .orElseThrow(() -> new RecordNotFoundException("Record", id));
    }

    @Override
    public Page<T> findAll(int page, int limit) {
        final Pageable pageable = PageRequest.of(page, limit);
        return mainRepository.findAllByIsDeletedIsFalse(pageable, entityGraphOf(findAllJoin()));
    }

    @Override
    public Page<T> findAll(T exampleEntity, int page, int limit) {
        exampleEntity.isDeleted = false;
        final Pageable pageable = PageRequest.of(page, limit);
        final Example<T> example = Example.of(exampleEntity);
        return mainRepository.findAll(example, pageable, entityGraphOf(findAllJoin()));
    }

    @Override
    public T create(T entity) {
        final T savedEntity = mainRepository.save(entity);
        return findSavedEntityById(savedEntity.id);
    }

    @Override
    public T update(T entity, long id) {
        final T old = findById(id);
        if (!Objects.equals(old.version, entity.version)) {
            throw new VersionException();
        }
        BeanUtils.copyProperties(entity, old);
        final T savedEntity = mainRepository.save(old);
        return findSavedEntityById(savedEntity.id);
    }

    @Override
    public T delete(long id) {
        final T entity = findById(id);
        entity.isDeleted = false;
        return mainRepository.save(entity);
    }

    /**
     * @return EntityGraph to automatically join.
     */
    private @NotNull EntityGraph entityGraphOf(String[] fields) {
        return ArrayUtils.isEmpty(fields)
                ? EntityGraph.NOOP
                : DynamicEntityGraph.loading(List.of(fields));
    }

    /**
     * @return just created or updated Entity
     * @see SimpleCurdService#create(BaseEntity)
     * @see SimpleCurdService#update(BaseEntity, long)
     */
    private T findSavedEntityById(long id) {
        return mainRepository.findById(id, entityGraphOf(savedEntityJoin()))
                .orElseThrow(() -> new RecordNotFoundException("Record", id));
    }

    /**
     * @return fields you want to join, when {@link SimpleCurdService#findById(long)}
     * @see OneToMany
     * @see ManyToOne
     * @see SimpleCurdService#findById(long)
     */
    protected abstract String[] findByIdJoin();

    /**
     * @return fields you want to join, when {@link SimpleCurdService#findAll(int, int)}, {@link SimpleCurdService#findAll(BaseEntity, int, int)}
     * @see OneToMany
     * @see ManyToOne
     * @see SimpleCurdService#findAll(int, int)
     * @see SimpleCurdService#findAll(BaseEntity, int, int)
     */
    protected abstract String[] findAllJoin();


    /**
     * findJoinById to attach all @{@link ManyToOne} relationship fields.
     *
     * @return all @{@link ManyToOne} fields of entity
     * @see ManyToOne
     * @see SimpleCurdService#create(BaseEntity)
     * @see SimpleCurdService#update(BaseEntity, long)
     */
    protected abstract String[] savedEntityJoin();
}
