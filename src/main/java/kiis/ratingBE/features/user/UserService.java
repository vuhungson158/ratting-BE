package kiis.ratingBE.features.user;

import com.cosium.spring.data.jpa.entity.graph.domain2.EntityGraph;
import kiis.ratingBE.common.SimpleCurdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends SimpleCurdService<UserEntity> {

    @Autowired
    public UserService(UserRepository userRepository) {
        super(userRepository);
    }

    @Override
    protected EntityGraph defaultEntityGraph() {
        return EntityGraph.NOOP;
    }

    @Override
    protected UserEntity findSavedEntityJoin(long id) {
        return null;
    }
}
