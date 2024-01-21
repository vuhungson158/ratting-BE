package kiis.ratingBE.model.teacher;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import kiis.ratingBE.model.common.JoinEntity;
import kiis.ratingBE.model.subject.SubjectEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teacher")
public class TeacherJoinEntity extends TeacherBaseModel implements JoinEntity {
    @OneToMany(mappedBy = "joinTeacher")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public List<SubjectEntity> subjects = new ArrayList<>();
}
