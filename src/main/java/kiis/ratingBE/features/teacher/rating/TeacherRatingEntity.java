package kiis.ratingBE.features.teacher.rating;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import kiis.ratingBE.common.BaseEntity;
import kiis.ratingBE.features.teacher.base.TeacherEntity;
import kiis.ratingBE.features.user.UserEntity;

@Entity
@Table(name = "teacher-rating")
public class TeacherRatingEntity extends BaseEntity {

    @Min(value = 0, message = "Min = 0")
    @Max(value = 100, message = "Max = 100")
    public int enthusiasm;

    @Min(value = 0, message = "Min = 0")
    @Max(value = 100, message = "Max = 100")
    public int friendly;

    @Min(value = 0, message = "Min = 0")
    @Max(value = 100, message = "Max = 100")
    public int erudition;

    @Min(value = 0, message = "Min = 0")
    @Max(value = 100, message = "Max = 100")
    public int pedagogical;

    @Min(value = 0, message = "Min = 0")
    @Max(value = 10, message = "Max = 10")
    public int star;

    /**
     * @see TeacherRatingEntity#teacher
     */
    @NotNull
    @Column(name = "teacher_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public Long teacherId;

    /**
     * @see TeacherRatingEntity#teacherId
     */
    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false, insertable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(allOf = TeacherEntity.class)
    public TeacherEntity teacher;

    /**
     * @see TeacherRatingEntity#user
     */
    @NotNull
    @Column(name = "user_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public Long userId;

    /**
     * @see TeacherRatingEntity#userId
     */
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(allOf = UserEntity.class)
    public UserEntity user;
}
