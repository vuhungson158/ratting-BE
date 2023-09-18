package kiis.ratingBE.features.subject.rating;

import kiis.ratingBE.common.crud.CrudController;
import kiis.ratingBE.features.subject.rating.model.SubjectRatingAverage;
import kiis.ratingBE.features.subject.rating.model.SubjectRatingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/subject-rating")
@RestController
public class SubjectRatingController
        extends CrudController<SubjectRatingEntity>
        implements SubjectRatingEndpoint {

    private final SubjectRatingService subjectRatingService;

    @Autowired
    public SubjectRatingController(SubjectRatingService subjectRatingService) {
        super(subjectRatingService);
        this.subjectRatingService = subjectRatingService;
    }

    @Override
    @GetMapping("/subjectId/{subjectId}")
    public SubjectRatingAverage findAverageBySubjectId(@PathVariable long subjectId) {
        return subjectRatingService.findAverageBySubjectId(subjectId);
    }

    @Override
    @GetMapping("/userId/{userId}")
    public SubjectRatingAverage findAverageByUserId(@PathVariable long userId) {
        return subjectRatingService.findAverageByUserId(userId);
    }

    @Override
    @GetMapping("/findOne")
    public SubjectRatingEntity findBySubjectIdAndUserId(long subjectId, long userId) {
        return subjectRatingService.findBySubjectIdAndUserId(subjectId, userId);
    }
}
