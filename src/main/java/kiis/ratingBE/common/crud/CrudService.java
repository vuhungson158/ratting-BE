package kiis.ratingBE.common.crud;

import kiis.ratingBE.common.BaseEntity;
import kiis.ratingBE.common.CommonRepository;
import kiis.ratingBE.exception.RecordNotFoundException;
import kiis.ratingBE.exception.VersionException;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Objects;

public abstract class CrudService<Entity extends BaseEntity>
        implements Crud<Entity> {
    protected abstract CommonRepository<Entity> getCrudRepository();

    @Override
    public Entity findById(long id) {
        final CommonRepository<Entity> crudRepository = getCrudRepository();
        return crudRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Record", id));
    }

    @Override
    public Page<Entity> findAll(int page, int limit) {
        final CommonRepository<Entity> crudRepository = getCrudRepository();
        final Pageable pageable = PageRequest.of(page, limit);
        return crudRepository.findAllByIsDeletedIsFalse(pageable);
    }

    @Override
    public @NotNull Page<Entity> findAll(@NotNull Entity exampleEntity, int page, int limit) {
        final CommonRepository<Entity> crudRepository = getCrudRepository();
        exampleEntity.isDeleted = false;
        final Pageable pageable = PageRequest.of(page, limit);
        final Example<Entity> example = Example.of(exampleEntity);
        return crudRepository.findAll(example, pageable);
    }

    @Override
    public @NotNull Entity create(@NotNull Entity entity) {
        final CommonRepository<Entity> crudRepository = getCrudRepository();
        return crudRepository.save(entity);
    }

    @Override
    public @NotNull Entity update(@NotNull Entity entity, long id) {
        final CommonRepository<Entity> crudRepository = getCrudRepository();
        final Entity old = findById(id);
        if (!Objects.equals(old.version, entity.version)) {
            throw new VersionException();
        }
        BeanUtils.copyProperties(entity, old);
        return crudRepository.save(old);
    }

    @Override
    public @NotNull Entity delete(long id) {
        final CommonRepository<Entity> crudRepository = getCrudRepository();
        final Entity entity = findById(id);
        entity.isDeleted = false;
        return crudRepository.save(entity);
    }
}
