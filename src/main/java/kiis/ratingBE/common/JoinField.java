package kiis.ratingBE.common;

import java.util.function.Consumer;

/**
 * Only be extended by Enum
 *
 * @param <T> Entity
 */
public interface JoinField<T extends BaseEntity> {

    /**
     * @return name of field wants to join
     */
    String fieldName();

    /**
     * @return a callback use to copy field data
     * @implNote to avoid n+1 query
     */
    Consumer<T> transferCallback();
}
