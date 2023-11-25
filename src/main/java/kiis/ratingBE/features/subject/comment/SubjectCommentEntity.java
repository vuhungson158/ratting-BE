package kiis.ratingBE.features.subject.comment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;
import kiis.ratingBE.common.comment.CommentEntity;
import kiis.ratingBE.features.subject.base.SubjectEntity;

@Entity
@Table(
        name = "subject_comment",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"subject_id", "user_id"}),
        }
)
public class SubjectCommentEntity extends CommentEntity {

    /**
     * @see SubjectCommentEntity#subject
     */
    @Column(name = "subject_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public Long subjectId;

    /**
     * @see SubjectCommentEntity#subjectId
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    public SubjectEntity joinSubject;

    /**
     * @see SubjectCommentEntity#subjectId
     */
    @Transient
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(allOf = SubjectEntity.class)
    public SubjectEntity subject;
}
