package kiis.ratingBE.features.teacher.comment;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import kiis.ratingBE.common.comment.ReactBaseEntity;

@Entity
@Table(
        name = "teacher_comment_react",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"comment_id", "user_id"})
        }
)
public class TeacherCommentReactEntity extends ReactBaseEntity<TeacherCommentEntity> {
}
