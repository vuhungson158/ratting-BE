package kiis.ratingBE.features.subject.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import kiis.ratingBE.common.BaseEntity;
import kiis.ratingBE.enums.Department;
import kiis.ratingBE.enums.subjectClassification.Small;
import kiis.ratingBE.features.teacher.base.TeacherEntity;

@Entity
@Table(name = "subject")
public class SubjectEntity extends BaseEntity {

    @Min(value = 1, message = "Min = 1")
    @Max(value = 6, message = "Max = 6")
    @Column(nullable = false)
    public Integer credit;

    @Min(value = 1, message = "Min = 1")
    @Max(value = 4, message = "Max = 4")
    public Integer formYear;

    @NotBlank
    public String name;

    @NotBlank
    @Enumerated(EnumType.STRING)
    public Department department;

    @NotBlank
    @Enumerated(EnumType.STRING)
    public Small classification;

    @NotNull
    public Boolean require;

    @NotBlank
    public String semester;

    @NotBlank
    public String schedule;

    /**
     * @see SubjectEntity#teacher
     */
    @Column(name = "teacher_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public Long teacherId;

    /**
     * @see SubjectEntity#teacherId
     */
    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false, insertable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(allOf = TeacherEntity.class)
    public TeacherEntity teacher;
}