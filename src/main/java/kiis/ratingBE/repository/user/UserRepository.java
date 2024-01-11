package kiis.ratingBE.repository.user;

import kiis.ratingBE.common.CommonRepository;
import kiis.ratingBE.model.user.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends
        CommonRepository<UserEntity> {

    Optional<UserEntity> findByEmail(String email);
//
//    Optional<UserEntity> findByEmailAndPassword(String email, String password);
//
//    boolean existsByEmail(String email);
//
//    long countByRole(UserRole role);
}
