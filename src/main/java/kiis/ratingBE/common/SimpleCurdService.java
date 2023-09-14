package kiis.ratingBE.common;

import com.cosium.spring.data.jpa.entity.graph.domain2.DynamicEntityGraph;
import com.cosium.spring.data.jpa.entity.graph.domain2.EntityGraph;
import kiis.ratingBE.exception.RecordNotFoundException;
import kiis.ratingBE.exception.VersionException;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.Contract;
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
        return mainRepository.findById(id, defaultEntityGraph())
                .orElseThrow(() -> new RecordNotFoundException("Record", id));
    }

    @Override
    public Page<T> findAll(int page, int limit) {
        final Pageable pageable = PageRequest.of(page, limit);
        return mainRepository.findAllByIsDeletedIsFalse(pageable, defaultEntityGraph());
    }

    @Override
    public Page<T> findAll(T exampleEntity, int page, int limit) {
        exampleEntity.isDeleted = false;
        final Pageable pageable = PageRequest.of(page, limit);
        final Example<T> example = Example.of(exampleEntity);
        return mainRepository.findAll(example, pageable, defaultEntityGraph());
    }

    @Override
    public T findByIdJoin(long id, JoinField<T>[] joinFields) {
        return null;
    }

    @Override
    public Page<T> findAllJoin(int page, int limit, JoinField<T>[] joinFields) {
        return null;
    }

    @Override
    public Page<T> findAllJoin(T exampleEntity, int page, int limit, JoinField<T>[] joinFields) {
        return null;
    }

    @Override
    public T create(T entity) {
        return mainRepository.save(entity);
    }

    @Override
    public T update(T entity, long id) {
        final T old = findById(id);
        if (!Objects.equals(old.version, entity.version)) {
            throw new VersionException();
        }
        BeanUtils.copyProperties(entity, old);
        return mainRepository.save(old);
    }

    @Override
    public T delete(long id) {
        final T entity = findById(id);
        entity.isDeleted = false;
        return mainRepository.save(entity);
    }

    /**
     * @return EntityGraph to automatically join. Use for all Common GetMapping
     */
    protected abstract EntityGraph defaultEntityGraph();


    /**
     * @return join nothing
     */
    protected static @NotNull EntityGraph noJoin() {
        return EntityGraph.NOOP;
    }

    /**
     * @param field must be Entity's OneToMany or ManyToOne field
     * @return DynamicEntityGraph
     */
    @Contract("_ -> new")
    protected static @NotNull EntityGraph join(String field) {
        return joins(field);
    }

    /**
     * @param fields must be Entity's OneToMany or ManyToOne fields
     * @return DynamicEntityGraph
     */
    @Contract("_ -> new")
    protected static @NotNull EntityGraph joins(String... fields) {
        return DynamicEntityGraph.loading(List.of(fields));
    }
}
