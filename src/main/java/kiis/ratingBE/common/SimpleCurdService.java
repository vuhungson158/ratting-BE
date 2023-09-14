package kiis.ratingBE.common;

import com.cosium.spring.data.jpa.entity.graph.domain2.DynamicEntityGraph;
import com.cosium.spring.data.jpa.entity.graph.domain2.EntityGraph;
import kiis.ratingBE.exception.RecordNotFoundException;
import kiis.ratingBE.exception.VersionException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public abstract class SimpleCurdService<T extends BaseEntity>
        implements SimpleCurd<T> {

    private final SimpleCurdRepository<T> mainRepository;

    @Override
    public T findById(long id) {
        return findByIdJoin(id, null);
    }

    @Override
    public Page<T> findAll(int page, int limit) {
        return findAllJoin(page, limit, null);
    }

    @Override
    public Page<T> findAll(T exampleEntity, int page, int limit) {
        return findAllJoin(exampleEntity, page, limit, null);
    }

    @Override
    public T findByIdJoin(long id, JoinField<T>[] joinFields) {
        final T result = mainRepository.findById(id, joins(joinFields))
                .orElseThrow(() -> new RecordNotFoundException("Record", id));
        transferFields(result, joinFields);
        return result;
    }

    @Override
    public Page<T> findAllJoin(int page, int limit, JoinField<T>[] joinFields) {
        final Pageable pageable = PageRequest.of(page, limit);
        final Page<T> results = mainRepository.findAllByIsDeletedIsFalse(pageable, joins(joinFields));
        transferFields(results, joinFields);
        return results;
    }

    @Override
    public Page<T> findAllJoin(@NotNull T exampleEntity, int page, int limit, JoinField<T>[] joinFields) {
        exampleEntity.isDeleted = false;
        final Pageable pageable = PageRequest.of(page, limit);
        final Example<T> example = Example.of(exampleEntity);
        final Page<T> results = mainRepository.findAll(example, pageable, joins(joinFields));
        transferFields(results, joinFields);
        return results;
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

    private void transferFields(T result, JoinField<T>[] joinFields) {
        transferFields(new PageImpl<>(List.of(result)), joinFields);
    }

    private void transferFields(@NotNull Page<T> results, JoinField<T>[] joinFields) {
        if (Objects.nonNull(joinFields)) {
            for (final JoinField<T> joinField : joinFields) {
                results.forEach(result -> joinField.transferCallback().accept(result));
            }
        }
    }

    /**
     * @return join nothing
     */
    protected static @NotNull EntityGraph noJoin() {
        return EntityGraph.NOOP;
    }

    /**
     * @param joinFields must be Entity's OneToMany or ManyToOne fields
     * @return DynamicEntityGraph
     */
    @SafeVarargs
    @Contract("_ -> new")
    protected final @NotNull EntityGraph joins(@NotNull JoinField<T>... joinFields) {
        if (ArrayUtils.isEmpty(joinFields) || Objects.isNull(joinFields)) {
            return noJoin();
        }
        final List<String> fieldNames = Arrays.stream(joinFields)
                .map(JoinField::fieldName)
                .toList();
        return DynamicEntityGraph.loading(fieldNames);
    }
}
