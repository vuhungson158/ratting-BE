package kiis.ratingBE.common.comment;

import jakarta.persistence.MappedSuperclass;
import kiis.ratingBE.common.userAction.UserActionBaseEntity;


@MappedSuperclass
public abstract class ReactEntity extends UserActionBaseEntity {

    /**
     * True = like<br>
     * False = dislike
     */
    public boolean react;
}
