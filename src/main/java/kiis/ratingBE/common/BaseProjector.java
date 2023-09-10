package kiis.ratingBE.common;

import java.time.Instant;

@SuppressWarnings("unused")
public interface BaseProjector {

    /**
     * @see BaseEntity#id
     */
    Long getId();

    /**
     * @see BaseEntity#createdAt
     */
    Instant getCreatedAt();

    /**
     * @see BaseEntity#createdBy
     */
    String getCreatedBy();

    /**
     * @see BaseEntity#updatedAt
     */
    Instant getUpdatedAt();

    /**
     * @see BaseEntity#updatedBy
     */
    String getUpdatedBy();

    /**
     * @see BaseEntity#isDeleted
     */
    Boolean getIsDeleted();

    /**
     * @see BaseEntity#version
     */
    Integer getVersion();
}
