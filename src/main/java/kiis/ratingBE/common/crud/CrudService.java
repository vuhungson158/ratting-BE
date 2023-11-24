package kiis.ratingBE.common.crud;

import kiis.ratingBE.common.BaseEntity;
import kiis.ratingBE.common.CommonRepository;
import kiis.ratingBE.exception.RecordNotFoundException;
import kiis.ratingBE.exception.VersionException;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Objects;

@RequiredArgsConstructor
public abstract class CrudService<Entity extends BaseEntity>
        implements Crud<Entity> {
    private final CommonRepository<Entity> crudRepository;

    @Override
    public final Entity findById(long id) {
        return crudRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Record", id));
    }

    @Override
    public final Page<Entity> findAll(int page, int limit) {
        final Pageable pageable = PageRequest.of(page, limit);
        return crudRepository.findAllByIsDeletedIsFalse(pageable);
    }

    @Override
    public final Page<Entity> findAll(@NotNull Entity exampleEntity, int page, int limit) {
        exampleEntity.isDeleted = false;
        final Pageable pageable = PageRequest.of(page, limit);
        final Example<Entity> example = Example.of(exampleEntity);
        return crudRepository.findAll(example, pageable);
    }

    @Override
    public final Entity create(Entity entity) {
        return crudRepository.save(entity);
    }

    @Override
    public final Entity update(@NotNull Entity entity, long id) {
        final Entity old = findById(id);
        if (!Objects.equals(old.version, entity.version)) {
            throw new VersionException();
        }
        BeanUtils.copyProperties(entity, old);
        return crudRepository.save(old);
    }

    @Override
    public final Entity delete(long id) {
        final Entity entity = findById(id);
        entity.isDeleted = false;
        return crudRepository.save(entity);
    }
}
