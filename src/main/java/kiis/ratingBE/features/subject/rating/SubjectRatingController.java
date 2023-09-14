package kiis.ratingBE.features.subject.rating;

import kiis.ratingBE.common.crud.CrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public List<SubjectRatingEntity> findAverageBySubjectId(long subjectId) {
        return subjectRatingService.findAverageBySubjectId(subjectId);
    }

    @Override
    public List<SubjectRatingEntity> findAverageByUserId(long userId) {
        return subjectRatingService.findAverageByUserId(userId);
    }

    @Override
    public SubjectRatingEntity findBySubjectIdAndUserId(long subjectId, long userId) {
        return subjectRatingService.findBySubjectIdAndUserId(subjectId, userId);
    }
}
