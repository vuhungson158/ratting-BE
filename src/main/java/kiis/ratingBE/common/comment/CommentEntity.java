package kiis.ratingBE.common.comment;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import kiis.ratingBE.common.userAction.UserActionEntity;

@MappedSuperclass
public abstract class CommentEntity extends UserActionEntity {
    @NotBlank
    public String comment;

    @Transient
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public Integer like;

    @Transient
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public Integer dislike;
}
