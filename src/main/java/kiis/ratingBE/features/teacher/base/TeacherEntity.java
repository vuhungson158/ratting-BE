package kiis.ratingBE.features.teacher.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import kiis.ratingBE.common.BaseEntity;
import kiis.ratingBE.enums.Gender;
import kiis.ratingBE.features.subject.base.SubjectEntity;
import kiis.ratingBE.validate.Furigana;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "teacher")
public class TeacherEntity extends BaseEntity {

    @NotBlank
    public String name;

    @NotBlank
    @Furigana
    public String furigana;

    @NotBlank
    public String nationality;

    @Enumerated(EnumType.STRING)
    @NotBlank
    public Gender gender;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    public Date dob;

    @OneToMany(mappedBy = "teacher")
    @JsonIgnore
    private List<SubjectEntity> subjectList = new ArrayList<>();

    @Transient
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public List<SubjectEntity> subjects = new ArrayList<>();

    /**
     * @see TeacherEntity#subjectList
     * @see TeacherEntity#subjects
     */
    public void transferSubjects() {
        subjects = subjectList
                .stream()
                .peek(subjectEntity -> subjectEntity.teacher = null)
                .toList();
    }
}
