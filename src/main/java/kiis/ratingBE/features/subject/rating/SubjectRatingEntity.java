package kiis.ratingBE.features.subject.rating;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import kiis.ratingBE.common.BaseEntity;
import kiis.ratingBE.features.subject.base.SubjectEntity;
import kiis.ratingBE.features.user.UserEntity;

@Entity
@Table(name = "subject-rating")
public class SubjectRatingEntity extends BaseEntity {

    @Min(value = 0, message = "Min = 0")
    @Max(value = 100, message = "Max = 100")
    public int practicality;

    @Min(value = 0, message = "Min = 0")
    @Max(value = 100, message = "Max = 100")
    public int easy;

    @Min(value = 0, message = "Min = 0")
    @Max(value = 10, message = "Max = 10")
    public int star;

    /**
     * @see SubjectRatingEntity#subject
     */
    @Column(name = "subject_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public Long subjectId;

    /**
     * @see SubjectRatingEntity#subjectId
     */
    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false, insertable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(allOf = SubjectEntity.class)
    public SubjectEntity subject;

    /**
     * @see SubjectRatingEntity#user
     */
    @Column(name = "user_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public Long userId;

    /**
     * @see SubjectRatingEntity#userId
     */
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(allOf = UserEntity.class)
    public UserEntity user;
}
