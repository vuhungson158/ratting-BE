package kiis.ratingBE.features.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import kiis.ratingBE.common.BaseEntity;
import kiis.ratingBE.enums.Gender;
import kiis.ratingBE.enums.UserRole;

@Entity
@Table(name = "auth_user")
public class UserEntity extends BaseEntity {

    @Column(unique = true)
    public String email;

    public String password;

    public String displayName;

    @Enumerated(EnumType.STRING)
    public Gender gender;

    @Enumerated(EnumType.STRING)
    public UserRole role;

    public record LoginForm(String email, String password) {
    }
}
