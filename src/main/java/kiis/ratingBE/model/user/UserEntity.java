package kiis.ratingBE.model.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import kiis.ratingBE.model.common.BaseEntity;
import kiis.ratingBE.enums.Gender;
import kiis.ratingBE.enums.UserRole;

@Entity
@Table(name = "auth_user")
public class UserEntity extends BaseEntity {

    @NotBlank
    @Column(unique = true)
    public String email;

    @NotBlank
    public String password;

    @NotBlank
    public String displayName;

    @NotNull
    @Enumerated(EnumType.STRING)
    public Gender gender;

    @NotNull
    @Enumerated(EnumType.STRING)
    public UserRole role;

    public record LoginForm(String email, String password) {
    }
}
