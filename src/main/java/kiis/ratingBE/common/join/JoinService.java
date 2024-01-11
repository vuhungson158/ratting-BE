package kiis.ratingBE.common.join;

import com.cosium.spring.data.jpa.entity.graph.domain2.DynamicEntityGraph;
import com.cosium.spring.data.jpa.entity.graph.domain2.EntityGraph;
import kiis.ratingBE.common.BaseEntity;
import kiis.ratingBE.common.CommonRepository;
import kiis.ratingBE.exception.RecordNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public abstract class JoinService<Entity extends BaseEntity, FieldEnum extends JoinField<Entity>>
        implements Join<Entity, FieldEnum> {
    private final CommonRepository<Entity> joinRepository;

    @Override
    public Entity findByIdJoin(long id, FieldEnum... joinFields) {
        final Entity result = joinRepository.findById(id, joins(joinFields))
                .orElseThrow(() -> new RecordNotFoundException("Record", id));
        transferFields(result, joinFields);
        return result;
    }

    @Override
    public Page<Entity> findAllJoin(int page, int limit, FieldEnum... joinFields) {
        final Pageable pageable = PageRequest.of(page, limit);
        final Page<Entity> results = joinRepository.findAllByIsDeletedIsFalse(pageable, joins(joinFields));
        transferFields(results, joinFields);
        return results;
    }

    @Override
    public Page<Entity> findAllJoin(@NotNull Entity exampleEntity, int page, int limit, FieldEnum... joinFields) {
        exampleEntity.isDeleted = false;
        final Pageable pageable = PageRequest.of(page, limit);
        final Example<Entity> example = Example.of(exampleEntity);
        final Page<Entity> results = joinRepository.findAll(example, pageable, joins(joinFields));
        transferFields(results, joinFields);
        return results;
    }

    /**
     * @param result     return of find one method
     * @param joinFields fields use to join
     */
    private void transferFields(Entity result, FieldEnum[] joinFields) {
        transferFields(new PageImpl<>(List.of(result)), joinFields);
    }

    /**
     * @param results    return of find all methods
     * @param joinFields fields use to join
     */
    private void transferFields(@NotNull Page<Entity> results, FieldEnum[] joinFields) {
        if (Objects.nonNull(joinFields)) {
            for (final FieldEnum joinField : joinFields) {
                results.forEach(result -> joinField.transferCallback().accept(result));
            }
        }
    }

    /**
     * @param joinFields must be Entity's OneToMany or ManyToOne fields
     * @return DynamicEntityGraph
     */
    @SafeVarargs
    @Contract("_ -> new")
    private @NotNull EntityGraph joins(@NotNull FieldEnum... joinFields) {
        if (Objects.isNull(joinFields) || ArrayUtils.isEmpty(joinFields)) {
            return EntityGraph.NOOP;
        }
        final List<String> fieldNames = Arrays.stream(joinFields)
                .map(JoinField::fieldName)
                .toList();
        return DynamicEntityGraph.loading(fieldNames);
    }
}
