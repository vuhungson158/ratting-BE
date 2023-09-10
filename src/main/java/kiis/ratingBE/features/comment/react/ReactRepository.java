package kiis.ratingBE.features.comment.react;

import kiis.ratingBE.common.SimpleCurdRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactRepository extends
        SimpleCurdRepository<ReactEntity> {
}
