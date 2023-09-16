package kiis.ratingBE.features.subject.rating;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import kiis.ratingBE.common.BaseEntity;
import kiis.ratingBE.features.subject.base.SubjectEntity;
import kiis.ratingBE.features.user.UserEntity;

@Entity
@Table(
        name = "subject_rating",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"subject_id", "user_id"})
        }
)
public class SubjectRatingEntity extends BaseEntity {

    @Min(value = 0, message = "Min = 0")
    @Max(value = 100, message = "Max = 100")
    public Integer practicality;

    @Min(value = 0, message = "Min = 0")
    @Max(value = 100, message = "Max = 100")
    public Integer easyToUnderstand;

    @Min(value = 0, message = "Min = 0")
    @Max(value = 10, message = "Max = 10")
    public Integer star;

    /**
     * @see SubjectRatingEntity#subject
     */
    @NotNull
    @Column(name = "subject_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public Long subjectId;

    /**
     * @see SubjectRatingEntity#subjectId
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id", nullable = false, insertable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(allOf = SubjectEntity.class)
    public SubjectEntity subject;

    /**
     * @see SubjectRatingEntity#user
     */
    @NotNull
    @Column(name = "user_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public Long userId;

    /**
     * @see SubjectRatingEntity#userId
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(allOf = UserEntity.class)
    public UserEntity user;
}
