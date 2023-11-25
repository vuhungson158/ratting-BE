package kiis.ratingBE.features.subject.comment;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import kiis.ratingBE.common.comment.ReactEntity;

@Entity
@Table(
        name = "subject_comment_react",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"comment_id", "user_id"})
        }
)
public class SubjectCommentReactEntity extends ReactEntity<SubjectCommentEntity> {
}
