package kiis.ratingBE.common.comment;

import jakarta.persistence.MappedSuperclass;
import kiis.ratingBE.common.userAction.UserActionEntity;


@MappedSuperclass
public abstract class ReactEntity extends UserActionEntity {

    /**
     * True = like<br>
     * False = dislike
     */
    public boolean react;
}
