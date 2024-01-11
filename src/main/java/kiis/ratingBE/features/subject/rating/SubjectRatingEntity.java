package kiis.ratingBE.features.subject.rating;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import kiis.ratingBE.common.rating.RatingBaseEntity;
import kiis.ratingBE.model.subject.SubjectEntity;

@Entity
@Table(
        name = "subject_rating",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"subject_id", "user_id"})
        }
)
public class SubjectRatingEntity extends RatingBaseEntity {

    @Min(value = 0, message = "Min = 0")
    @Max(value = 100, message = "Max = 100")
    public Integer practicality;

    @Min(value = 0, message = "Min = 0")
    @Max(value = 100, message = "Max = 100")
    public Integer easyToUnderstand;

    /**
     * @see SubjectRatingEntity#subject
     */
    @NotNull
    @Column(name = "subject_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public Long subjectId;

    /**
     * @see SubjectRatingEntity#subjectId
     * @see SubjectRatingEntity#subject
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    public SubjectEntity joinSubject;

    /**
     * @see SubjectRatingEntity#subjectId
     */
    @Transient
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(allOf = SubjectEntity.class)
    public SubjectEntity subject;
}
