package kiis.ratingBE.service.common;

import kiis.ratingBE.exception.RecordNotFoundException;
import kiis.ratingBE.exception.VersionException;
import kiis.ratingBE.helper.MappingUtil;
import kiis.ratingBE.model.common.BaseEntity;
import kiis.ratingBE.repository.common.CommonRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public abstract class CrudServiceTemplate<Entity extends BaseEntity>
        implements CrudService<Entity> {
    protected abstract CommonRepository<Entity> getCrudRepository();

    @Override
    public Entity findById(long id) {
        final CommonRepository<Entity> crudRepository = getCrudRepository();
        return crudRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Record", id));
    }

    @Override
    public Page<Entity> findAll(Pageable paging) {
        final CommonRepository<Entity> crudRepository = getCrudRepository();
        return crudRepository.findAllByIsDeletedIsFalse(paging);
    }

    @Override
    public @NotNull Page<Entity> findAll(@NotNull Example<Entity> filter, Pageable paging) {
        final CommonRepository<Entity> crudRepository = getCrudRepository();
        filter.getProbe().isDeleted = false;
        return crudRepository.findAll(filter, paging);
    }

    @Override
    public Page<Entity> findAll(Specification<Entity> filter, Pageable paging) {
        final CommonRepository<Entity> crudRepository = getCrudRepository();
        return crudRepository.findAll(filter, paging);
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
        MappingUtil.copyBaseEntityProperties(old, entity);
        return crudRepository.save(entity);
    }

    @Override
    public @NotNull Entity delete(long id) {
        final CommonRepository<Entity> crudRepository = getCrudRepository();
        final Entity entity = findById(id);
        entity.isDeleted = true;
        return crudRepository.save(entity);
    }
}
