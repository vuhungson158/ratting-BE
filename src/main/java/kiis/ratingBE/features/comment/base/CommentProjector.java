package kiis.ratingBE.features.comment.base;

import kiis.ratingBE.common.BaseProjector;
import kiis.ratingBE.common.Projector;
import kiis.ratingBE.features.subject.base.SubjectEntity;

/**
 * <pre>
 * mapping all fields of {@link SubjectEntity}
 * do not use this interface directly
 * make {@link Projector} extend this interface
 * and use {@link Projector} as return type of complicate Query (what need virtual column)
 * </pre>
 *
 * @author vuhungson
 * @see BaseProjector
 * @see SubjectEntity
 * @see Projector
 */
@SuppressWarnings("unused")
public interface CommentProjector extends BaseProjector {

    /**
     * @see SubjectEntity#teacherId
     */
    Long getTeacherId();
}