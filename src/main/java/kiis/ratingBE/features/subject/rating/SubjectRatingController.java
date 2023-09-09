package kiis.ratingBE.features.subject.rating;

import kiis.ratingBE.common.SimpleCurdController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/subject-rating")
@RestController
public class SubjectRatingController extends
        SimpleCurdController<SubjectRatingEntity> {

    @Autowired
    public SubjectRatingController(SubjectRatingService subjectRatingService) {
        super(subjectRatingService);
    }
}
