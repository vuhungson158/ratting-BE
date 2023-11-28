package kiis.ratingBE.features.teacher.rating;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import kiis.ratingBE.common.rating.RatingBaseEntity;
import kiis.ratingBE.features.teacher.base.TeacherEntity;

@Entity
@Table(
        name = "teacher_rating",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"teacher_id", "user_id"})
        }
)
public class TeacherRatingEntity extends RatingBaseEntity {

    @Min(value = 0, message = "Min = 0")
    @Max(value = 100, message = "Max = 100")
    public Integer enthusiasm;

    @Min(value = 0, message = "Min = 0")
    @Max(value = 100, message = "Max = 100")
    public Integer friendly;

    @Min(value = 0, message = "Min = 0")
    @Max(value = 100, message = "Max = 100")
    public Integer erudition;

    @Min(value = 0, message = "Min = 0")
    @Max(value = 100, message = "Max = 100")
    public Integer pedagogical;

    @NotNull
    @Column(name = "teacher_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public Long teacherId;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    public TeacherEntity joinTeacher;

    @Transient
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(allOf = TeacherEntity.class)
    public TeacherEntity teacher;
}
