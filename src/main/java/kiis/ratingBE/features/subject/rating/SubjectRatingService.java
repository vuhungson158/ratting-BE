package kiis.ratingBE.features.subject.rating;

import kiis.ratingBE.common.crud.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectRatingService
        extends CrudService<SubjectRatingEntity>
        implements SubjectRatingEndpoint {

    @Autowired
    public SubjectRatingService(SubjectRatingRepository subjectRatingRepository) {
        super(subjectRatingRepository);
    }

    @Override
    public List<SubjectRatingEntity> findAverageBySubjectId(long subjectId) {
        return null;
    }

    @Override
    public List<SubjectRatingEntity> findAverageByUserId(long userId) {
        return null;
    }

    @Override
    public SubjectRatingEntity findBySubjectIdAndUserId(long subjectId, long userId) {
        return null;
    }
}
