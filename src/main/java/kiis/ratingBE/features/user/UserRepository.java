package kiis.ratingBE.features.user;

import kiis.ratingBE.common.SimpleCurdRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends
        SimpleCurdRepository<UserEntity> {

    Optional<UserEntity> findByEmail(String email);
//
//    Optional<UserEntity> findByEmailAndPassword(String email, String password);
//
//    boolean existsByEmail(String email);
//
//    long countByRole(UserRole role);
}
