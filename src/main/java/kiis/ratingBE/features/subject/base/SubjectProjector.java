package kiis.ratingBE.features.subject.base;

import kiis.ratingBE.common.Projector;

/**
 * <pre>
 * mapping all fields of {@link SubjectEntity}
 * do not use this interface directly
 * make {@link Projector} extend this interface
 * and use {@link Projector} as return type of complicate Query (what need virtual column)
 * </pre>
 *
 * @author vuhungson
 * @see SubjectEntity
 * @see Projector
 */
public interface SubjectProjector {

    /**
     * @see SubjectEntity#teacherId
     */
    Long getTeacherId();
}