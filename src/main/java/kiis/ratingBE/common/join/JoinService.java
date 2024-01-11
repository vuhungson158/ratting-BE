package kiis.ratingBE.common.join;

import com.cosium.spring.data.jpa.entity.graph.domain2.DynamicEntityGraph;
import com.cosium.spring.data.jpa.entity.graph.domain2.EntityGraph;
import kiis.ratingBE.common.BaseEntity;
import kiis.ratingBE.common.CommonRepository;
import kiis.ratingBE.enums.foreignKey.ForeignKey;
import kiis.ratingBE.exception.RecordNotFoundException;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class JoinService<JoinEntity extends BaseEntity>
        implements Join<JoinEntity> {
    protected abstract CommonRepository<JoinEntity> getJoinRepository();

    protected abstract ForeignKey[] getJoinFields();

    @Override
    public JoinEntity findByIdJoin(long id) {
        final CommonRepository<JoinEntity> joinRepository = getJoinRepository();
        final ForeignKey[] foreignKeys = getJoinFields();

        return joinRepository.findById(id, joins(foreignKeys))
                .orElseThrow(() -> new RecordNotFoundException("Record", id));
    }

    @Override
    public Page<JoinEntity> findAllJoin(int page, int limit) {
        final CommonRepository<JoinEntity> joinRepository = getJoinRepository();
        final ForeignKey[] foreignKeys = getJoinFields();

        final Pageable pageable = PageRequest.of(page, limit);
        return joinRepository.findAllByIsDeletedIsFalse(pageable, joins(foreignKeys));
    }

    @Override
    public Page<JoinEntity> findAllJoin(@NotNull JoinEntity exampleEntity, int page, int limit) {
        final CommonRepository<JoinEntity> joinRepository = getJoinRepository();
        final ForeignKey[] foreignKeys = getJoinFields();

        exampleEntity.isDeleted = false;
        final Pageable pageable = PageRequest.of(page, limit);
        final Example<JoinEntity> example = Example.of(exampleEntity);
        return joinRepository.findAll(example, pageable, joins(foreignKeys));
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
