package kiis.ratingBE.service.common;

import com.cosium.spring.data.jpa.entity.graph.domain2.DynamicEntityGraph;
import com.cosium.spring.data.jpa.entity.graph.domain2.EntityGraph;
import kiis.ratingBE.enums.foreignKey.ForeignKey;
import kiis.ratingBE.exception.RecordNotFoundException;
import kiis.ratingBE.model.common.BaseEntity;
import kiis.ratingBE.repository.common.JoinRepository;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class JoinServiceTemplate<JoinEntity extends BaseEntity>
        implements JoinService<JoinEntity> {
    protected abstract JoinRepository<JoinEntity> getJoinRepository();

    protected abstract ForeignKey[] getJoinFields();

    @Override
    public JoinEntity findById(long id) {
        final JoinRepository<JoinEntity> joinRepository = getJoinRepository();
        final ForeignKey[] foreignKeys = getJoinFields();

        return joinRepository.findById(id, joins(foreignKeys))
                .orElseThrow(() -> new RecordNotFoundException("Record", id));
    }

    @Override
    public Page<JoinEntity> findAll(Pageable paging) {
        final JoinRepository<JoinEntity> joinRepository = getJoinRepository();
        final ForeignKey[] foreignKeys = getJoinFields();

        return joinRepository.findAllByIsDeletedIsFalse(paging, joins(foreignKeys));
    }

    @Override
    public Page<JoinEntity> findAll(@NotNull Example<JoinEntity> filter, Pageable paging) {
        final JoinRepository<JoinEntity> joinRepository = getJoinRepository();
        final ForeignKey[] foreignKeys = getJoinFields();

        filter.getProbe().isDeleted = false;
        return joinRepository.findAll(filter, paging, joins(foreignKeys));
    }

    @Override
    public Page<JoinEntity> findAll(Specification<JoinEntity> filter, Pageable paging) {
        final JoinRepository<JoinEntity> joinRepository = getJoinRepository();
        final ForeignKey[] foreignKeys = getJoinFields();

        return joinRepository.findAll(filter, paging, joins(foreignKeys));
    }

    /**
     * @param foreignKeys must be JoinEntity's OneToMany or ManyToOne fields
     * @return DynamicEntityGraph
     */
    @Contract("_ -> new")
    private @NotNull EntityGraph joins(@NotNull ForeignKey[] foreignKeys) {
        if (Objects.isNull(foreignKeys) || ArrayUtils.isEmpty(foreignKeys)) {
            return EntityGraph.NOOP;
        }
        final List<String> fieldNames = Arrays.stream(foreignKeys)
                .map(ForeignKey::fieldName)
                .toList();
        return DynamicEntityGraph.loading(fieldNames);
    }
}
