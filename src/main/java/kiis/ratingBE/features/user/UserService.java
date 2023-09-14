package kiis.ratingBE.features.user;

import kiis.ratingBE.common.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends CrudService<UserEntity> {

    @Autowired
    public UserService(UserRepository userRepository) {
        super(userRepository);
    }
}
