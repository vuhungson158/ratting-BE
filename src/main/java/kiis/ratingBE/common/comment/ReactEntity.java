package kiis.ratingBE.common.comment;

import jakarta.persistence.MappedSuperclass;
import kiis.ratingBE.common.UserActionBaseEntity;


@MappedSuperclass
public class ReactEntity extends UserActionBaseEntity {

    /**
     * True = like<br>
     * False = dislike
     */
    public boolean react;
}
