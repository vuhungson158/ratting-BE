package kiis.ratingBE.features.comment.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import kiis.ratingBE.common.BaseEntity;
import kiis.ratingBE.features.subject.base.SubjectEntity;
import kiis.ratingBE.features.teacher.base.TeacherEntity;
import kiis.ratingBE.features.user.UserEntity;

@Entity
@Table(name = "comment")
public class CommentEntity extends BaseEntity {

    @NotBlank
    public String comment;

    @Transient
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public Integer like;

    @Transient
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public Integer dislike;

    /**
     * @see CommentEntity#teacher
     */
    @Column(name = "teacher_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public Long teacherId;

    /**
     * @see CommentEntity#teacherId
     */
    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false, insertable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(allOf = TeacherEntity.class)
    public TeacherEntity teacher;

    /**
     * @see CommentEntity#subject
     */
    @Column(name = "subject_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public Long subjectId;

    /**
     * @see CommentEntity#subjectId
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id", nullable = false, insertable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(allOf = SubjectEntity.class)
    public SubjectEntity subject;

    /**
     * @see CommentEntity#user
     */
    @NotNull
    @Column(name = "user_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public Long userId;

    /**
     * @see CommentEntity#userId
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(allOf = UserEntity.class)
    public UserEntity user;
}
