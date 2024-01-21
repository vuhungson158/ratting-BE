package kiis.ratingBE.model.subject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import kiis.ratingBE.model.teacher.TeacherEntity;
import kiis.ratingBE.model.teacher.TeacherJoinEntity;

@Entity
@Table(name = "subject")
public class SubjectEntity extends SubjectBaseModel {
    /**
     * transient with front-end, only use for {@link TeacherJoinEntity#subjects}
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    public TeacherEntity joinTeacher;
}