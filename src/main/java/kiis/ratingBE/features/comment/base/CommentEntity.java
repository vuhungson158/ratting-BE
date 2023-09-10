package kiis.ratingBE.features.comment.base;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import kiis.ratingBE.common.BaseEntity;

@Entity
@Table(name = "comment")
public class CommentEntity extends BaseEntity {
}
