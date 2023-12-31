package kiis.ratingBE.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public Long id;

    @CreatedDate
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public Instant createdAt;

    @CreatedBy
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public String createdBy;

    @LastModifiedDate
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public Instant updatedAt;

    @LastModifiedBy
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public String updatedBy;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public Boolean isDeleted = false;

    @Version
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public Integer version;
}
