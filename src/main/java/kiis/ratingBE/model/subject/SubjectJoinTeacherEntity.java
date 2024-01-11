package kiis.ratingBE.model.subject;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import kiis.ratingBE.model.teacher.TeacherEntity;

@Entity
@Table(name = "subject")
public class SubjectJoinTeacherEntity extends SubjectBaseModel {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", nullable = false, insertable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public TeacherEntity teacher;
}
