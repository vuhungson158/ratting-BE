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
import kiis.ratingBE.common.BaseEntity;
import kiis.ratingBE.enums.Department;
import kiis.ratingBE.enums.subjectClassification.Small;
import kiis.ratingBE.features.teacher.base.TeacherEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "subject")
@AllArgsConstructor
@NoArgsConstructor
public class SubjectEntity extends BaseEntity {

    @Min(value = 1, message = "Min = 1")
    @Max(value = 6, message = "Max = 6")
    @Column(nullable = false)
    public Integer credit;

    @Min(value = 1, message = "Min = 1")
    @Max(value = 4, message = "Max = 4")
    public Integer formYear;

    public String name;

    @Enumerated(EnumType.STRING)
    public Department department;

    @Enumerated(EnumType.STRING)
    public Small classification;

    public Boolean require;

    public String semester;

    public String schedule;

    @Column(name = "teacher_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public Long teacherId;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false, insertable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(allOf = TeacherEntity.class)
    public TeacherEntity teacher;
}