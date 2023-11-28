package kiis.ratingBE.common.rating;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import kiis.ratingBE.common.userAction.UserActionBaseEntity;

@MappedSuperclass
public abstract class RatingBaseEntity extends UserActionBaseEntity {

    @Min(value = 0, message = "Min = 0")
    @Max(value = 10, message = "Max = 10")
    public Integer star;
}
