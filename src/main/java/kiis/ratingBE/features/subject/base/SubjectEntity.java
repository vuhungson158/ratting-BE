package kiis.ratingBE.features.subject.base;

import com.fasterxml.jackson.annotation.JsonProperty;
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

//@EntityListeners(SubjectEntityListener.class)
//@TypeDef(name = "department", typeClass = PostgreSQLEnumType.class)
//@TypeDef(name = "classification", typeClass = PostgreSQLEnumType.class)
@Entity
@Table(name = "subject")
@AllArgsConstructor
@NoArgsConstructor
public class SubjectEntity extends BaseEntity {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "teacher_id")
    public Long teacherId;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id", insertable = false, updatable = false)
    public TeacherEntity teacher;

    @Min(value = 1, message = "Min = 1")
    @Max(value = 6, message = "Max = 6")
    public Integer credit;

    @Min(value = 1, message = "Min = 1")
    @Max(value = 4, message = "Max = 4")
    public Integer formYear;

    public String name;

    //    @Type(PostgreSQLEnumType.class)
    @Enumerated(EnumType.STRING)
    public Department department;

    @Enumerated(EnumType.STRING)
    public Small classification;

    public Boolean require = false;

    public String semester;

    public String schedule;
}