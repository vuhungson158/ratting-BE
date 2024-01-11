package kiis.ratingBE.features.teacher.comment;

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
import kiis.ratingBE.common.comment.CommentBaseEntity;
import kiis.ratingBE.model.teacher.TeacherEntity;

@Entity
@Table(
        name = "teacher_comment",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"teacher_id", "user_id"}),
        }
)
public class TeacherCommentEntity extends CommentBaseEntity {

    /**
     * @see TeacherCommentEntity#teacher
     */
    @Column(name = "teacher_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public Long teacherId;

    /**
     * @see TeacherCommentEntity#teacherId
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    public TeacherEntity joinTeacher;

    /**
     * @see TeacherCommentEntity#teacherId
     */
    @Transient
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(allOf = TeacherEntity.class)
    public TeacherEntity teacher;
}
