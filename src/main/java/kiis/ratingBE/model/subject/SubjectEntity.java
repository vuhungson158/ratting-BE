package kiis.ratingBE.model.subject;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "subject")
public class SubjectEntity extends SubjectBaseModel {
    @NotNull
    @Column(name = "teacher_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public Long teacherId;
}