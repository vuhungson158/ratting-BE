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
import kiis.ratingBE.common.BaseEntity;
import kiis.ratingBE.features.user.UserEntity;

@MappedSuperclass
public abstract class UserActionEntity extends BaseEntity {

    /**
     * @see UserActionEntity#joinUser
     * @see UserActionEntity#user
     */
    @NotNull
    @Column(name = "user_id")
    @JsonIgnore
    public Long userId;

    /**
     * @see UserActionEntity#userId
     * @see UserActionEntity#user
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    public UserEntity joinUser;

    /**
     * @see UserActionEntity#userId
     * @see UserActionEntity#joinUser
     */
    @Transient
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(allOf = UserEntity.class)
    public UserEntity user;
}
