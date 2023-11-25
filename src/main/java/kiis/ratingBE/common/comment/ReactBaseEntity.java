package kiis.ratingBE.common.comment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import kiis.ratingBE.common.userAction.UserActionBaseEntity;


@MappedSuperclass
public abstract class ReactBaseEntity<Entity extends CommentBaseEntity> extends UserActionBaseEntity {

    /**
     * True = like<br>
     * False = dislike
     */
    public boolean react;

    /**
     * @see ReactBaseEntity#comment
     */
    @Column(name = "comment_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public Long commentId;

    /**
     * @see ReactBaseEntity#commentId
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    public Entity joinComment;

    /**
     * @see ReactBaseEntity#commentId
     */
    @Transient
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(allOf = CommentBaseEntity.class)
    public Entity comment;
}
