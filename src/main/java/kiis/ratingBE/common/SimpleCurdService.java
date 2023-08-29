package kiis.ratingBE.common;

import kiis.ratingBE.exception.RecordNotFoundException;
import kiis.ratingBE.exception.VersionException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Objects;

@RequiredArgsConstructor
public abstract class SimpleCurdService<T extends BaseEntity>
        implements SimpleCurd<T> {

    private final SimpleCurdRepository<T> mainRepository;

    @Override
    public T findById(long id) {
        return mainRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Record", id));
    }

    @Override
    public Page<T> findAll(int page, int limit) {
        final Pageable pageable = PageRequest.of(page, limit);
        return mainRepository.findAll(pageable);
    }

    @Override
    public Page<T> findAll(T exampleEntity, int page, int limit) {
        final Pageable pageable = PageRequest.of(page, limit);
        final Example<T> example = Example.of(exampleEntity);
        return mainRepository.findAll(example, pageable);
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
}
