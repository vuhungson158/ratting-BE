package kiis.ratingBE.features.comment.react;

import kiis.ratingBE.common.SimpleCurdController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/react")
@RestController
public class ReactController extends
        SimpleCurdController<ReactEntity> {

    @Autowired
    public ReactController(ReactService reactService) {
        super(reactService);
    }
}
