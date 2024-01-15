package kiis.ratingBE.common.userAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
import kiis.ratingBE.model.BaseEntity;
import kiis.ratingBE.model.user.UserEntity;

@MappedSuperclass
public abstract class UserActionBaseEntity extends BaseEntity {

    /**
     * @see UserActionBaseEntity#joinUser
     * @see UserActionBaseEntity#user
     */
    @NotNull
    @Column(name = "user_id")
    @JsonIgnore
    public Long userId;

    /**
     * @see UserActionBaseEntity#userId
     * @see UserActionBaseEntity#user
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    public UserEntity joinUser;

    /**
     * @see UserActionBaseEntity#userId
     * @see UserActionBaseEntity#joinUser
     */
    @Transient
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(allOf = UserEntity.class)
    public UserEntity user;
}
