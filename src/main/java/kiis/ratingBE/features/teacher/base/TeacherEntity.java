package kiis.ratingBE.features.teacher.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import kiis.ratingBE.common.BaseEntity;
import kiis.ratingBE.enums.Gender;
import kiis.ratingBE.features.subject.base.SubjectEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


//@TypeDef(name = "gender", typeClass = PostgreSQLEnumType.class)
@Entity
@Table(name = "teacher")
@AllArgsConstructor
@NoArgsConstructor
public class TeacherEntity extends BaseEntity {

    @OneToMany(mappedBy = "teacher")
    @JsonIgnore
    public List<SubjectEntity> subjectList;

    public String name, nationality;

//    @Type(type = "gender")
    @Enumerated(EnumType.STRING)
    public Gender gender;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    public Date dob;
}
