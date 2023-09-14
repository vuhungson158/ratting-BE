package kiis.ratingBE.features.comment.react;

import kiis.ratingBE.common.SimpleCurdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReactService extends
        SimpleCurdService<ReactEntity> {

    @Autowired
    public ReactService(ReactRepository reactRepository) {
        super(reactRepository);
    }
}
