package kiis.ratingBE.features.comment.react;

import kiis.ratingBE.common.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReactService extends
        CrudService<ReactEntity> {

    @Autowired
    public ReactService(ReactRepository reactRepository) {
        super(reactRepository);
    }
}
