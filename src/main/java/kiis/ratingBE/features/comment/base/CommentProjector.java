package kiis.ratingBE.features.comment.base;

import kiis.ratingBE.common.BaseProjector;
import kiis.ratingBE.features.user.UserProjector;

/**
 * @author vuhungson
 * @see BaseProjector
 */
@SuppressWarnings("unused")
public interface CommentProjector extends BaseProjector {

    /**
     * @see CommentEntity#comment
     */
    String getComment();

    /**
     * @see CommentEntity#like
     */
    Integer getLike();

    /**
     * @see CommentEntity#dislike
     */
    Integer getDislike();

    /**
     * @see CommentEntity#user
     */
    UserProjector getUser();

}