package kiis.ratingBE.service.common;

import com.cosium.spring.data.jpa.entity.graph.domain2.DynamicEntityGraph;
import com.cosium.spring.data.jpa.entity.graph.domain2.EntityGraph;
import kiis.ratingBE.enums.foreignKey.ForeignKey;
import kiis.ratingBE.exception.RecordNotFoundException;
import kiis.ratingBE.model.common.BaseEntity;
import kiis.ratingBE.model.common.JoinEntity;
import kiis.ratingBE.repository.common.JoinRepository;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class JoinServiceTemplate<Entity extends BaseEntity & JoinEntity>
        implements JoinService<Entity> {
    protected abstract JoinRepository<Entity> getJoinRepository();

    /**
     * @param joins recommend {@link JoinServiceTemplate#joins}
     */
    @Override
    public Entity findById(long id, EntityGraph joins) {
        final JoinRepository<Entity> joinRepository = getJoinRepository();
        return joinRepository.findById(id, joins)
                .orElseThrow(() -> new RecordNotFoundException("Record", id));
    }

    /**
     * @param joins recommend {@link JoinServiceTemplate#joins}
     */
    @Override
    public Page<Entity> findAll(Pageable paging, EntityGraph joins) {
        final JoinRepository<Entity> joinRepository = getJoinRepository();
        return joinRepository.findAllByIsDeletedIsFalse(paging, joins);
    }

    /**
     * @param joins recommend {@link JoinServiceTemplate#joins}
     */
    @Override
    public Page<Entity> findAll(@NotNull Example<Entity> filter, Pageable paging, EntityGraph joins) {
        final JoinRepository<Entity> joinRepository = getJoinRepository();
        filter.getProbe().isDeleted = false;
        return joinRepository.findAll(filter, paging, joins);
    }

    /**
     * @param joins recommend {@link JoinServiceTemplate#joins}
     */
    @Override
    public Page<Entity> findAll(Specification<Entity> filter, Pageable paging, EntityGraph joins) {
        final JoinRepository<Entity> joinRepository = getJoinRepository();
        return joinRepository.findAll(filter, paging, joins);
    }

    /**
     * @param foreignKeys must be Entity's OneToMany or ManyToOne fields
     * @return {@link DynamicEntityGraph}
     */
    @SafeVarargs
    public static <T extends Enum<T> & ForeignKey> EntityGraph joins(T... foreignKeys) {
        if (Objects.isNull(foreignKeys) || ArrayUtils.isEmpty(foreignKeys)) {
            return EntityGraph.NOOP;
        }
        final List<String> fieldNames = Arrays.stream(foreignKeys)
                .map(ForeignKey::fieldName)
                .toList();
        return DynamicEntityGraph.loading(fieldNames);
    }
}
