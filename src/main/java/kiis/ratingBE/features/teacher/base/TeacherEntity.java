package kiis.ratingBE.features.teacher.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import kiis.ratingBE.common.BaseEntity;
import kiis.ratingBE.enums.Gender;
import kiis.ratingBE.features.subject.base.SubjectEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "teacher")
@AllArgsConstructor
@NoArgsConstructor
public class TeacherEntity extends BaseEntity {

    public String name, nationality;

    @Enumerated(EnumType.STRING)
    public Gender gender;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    public Date dob;

    @OneToMany(mappedBy = "teacher")
    @JsonIgnore
    private List<SubjectEntity> subjectList = new ArrayList<>();

    @Transient
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
