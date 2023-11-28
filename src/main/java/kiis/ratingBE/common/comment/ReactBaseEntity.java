package kiis.ratingBE.common.comment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotEmpty;
import kiis.ratingBE.common.userAction.UserActionBaseEntity;
import kiis.ratingBE.enums.ReactType;

import java.util.Map;


@MappedSuperclass
public abstract class ReactBaseEntity<CommentEntity extends CommentBaseEntity> extends UserActionBaseEntity {

    @Enumerated(EnumType.STRING)
    @NotEmpty
    public ReactType react;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ElementCollection
    public Map<ReactType, Integer> reactMap = ReactType.defaultMap();

    /**
     * @see ReactBaseEntity#comment
     */
    @NotEmpty
    @Column(name = "comment_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public Long commentId;

    /**
     * @see ReactBaseEntity#commentId
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    public CommentEntity joinComment;

    /**
     * @see ReactBaseEntity#commentId
     */
    @Transient
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(allOf = CommentBaseEntity.class)
    public CommentEntity comment;
}
