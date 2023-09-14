package kiis.ratingBE.features.user;

import kiis.ratingBE.common.SimpleCurdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends SimpleCurdService<UserEntity> {

    @Autowired
    public UserService(UserRepository userRepository) {
        super(userRepository);
    }
}
