package kiis.ratingBE.features.comment.react;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import kiis.ratingBE.common.BaseEntity;
import kiis.ratingBE.features.comment.base.CommentEntity;
import kiis.ratingBE.features.user.UserEntity;

@Entity
@Table(name = "react")
public class ReactEntity extends BaseEntity {

    /**
     * True = like<br>
     * False = dislike
     */
    public boolean react;

    /**
     * @see ReactEntity#comment
     */
    @NotNull
    @Column(name = "comment_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public Long commentId;

    /**
     * @see ReactEntity#commentId
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id", nullable = false, insertable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(allOf = CommentEntity.class)
    public CommentEntity comment;

    /**
     * @see ReactEntity#user
     */
    @NotNull
    @Column(name = "user_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public Long userId;

    /**
     * @see ReactEntity#userId
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(allOf = UserEntity.class)
    public UserEntity user;
}
