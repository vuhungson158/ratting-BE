package kiis.ratingBE.model.subject;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import kiis.ratingBE.enums.Department;
import kiis.ratingBE.enums.subjectClassification.Small;
import kiis.ratingBE.model.common.BaseEntity;

@MappedSuperclass
public abstract class SubjectBaseModel extends BaseEntity {
    @NotBlank
    public String name;

    @Min(value = 1, message = "Min = 1")
    @Max(value = 6, message = "Max = 6")
    public Integer credit;

    @Min(value = 1, message = "Min = 1")
    @Max(value = 4, message = "Max = 4")
    public Integer registrableYear;

    @NotNull
    @Enumerated(EnumType.STRING)
    public Department department;

    @NotNull
    @Enumerated(EnumType.STRING)
    public Small classification;

    @NotNull
    public Boolean require;

    @NotBlank
    public String semester;

    @NotBlank
    public String schedule;

    @NotNull
    @Column(name = "teacher_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public Long teacherId;
}
