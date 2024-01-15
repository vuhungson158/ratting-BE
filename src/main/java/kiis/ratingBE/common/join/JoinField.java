package kiis.ratingBE.common.join;

import kiis.ratingBE.model.BaseEntity;

import java.util.function.Consumer;

/**
 * Only be extended by Enum
 *
 * @param <FieldEnum> Entity
 */
public interface JoinField<FieldEnum extends BaseEntity> {

    /**
     * @return name of field wants to join
     */
    String fieldName();

    /**
     * @return a callback use to copy field data
     * @implNote to avoid n+1 query
     */
    Consumer<FieldEnum> transferCallback();
}
