package kiis.ratingBE.features.subject.rating;

import kiis.ratingBE.common.crud.CrudService;
import kiis.ratingBE.exception.RecordNotFoundException;
import kiis.ratingBE.features.subject.rating.dao.SubjectRatingAverage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class SubjectRatingService
        extends CrudService<SubjectRatingEntity>
        implements SubjectRatingEndpoint {

    private final SubjectRatingRepository subjectRatingRepository;

    @Autowired
    public SubjectRatingService(SubjectRatingRepository subjectRatingRepository) {
        super(subjectRatingRepository);
        this.subjectRatingRepository = subjectRatingRepository;
    }

    @Override
    public SubjectRatingAverage findAverageBySubjectId(long subjectId) {
        return subjectRatingRepository
                .findAverageBySubjectId(subjectId)
                .to(SubjectRatingAverage.class);
    }

    @Override
    public SubjectRatingAverage findAverageByUserId(long userId) {
        return subjectRatingRepository
                .findAverageByUserId(userId)
                .to(SubjectRatingAverage.class);
    }

    @Override
    public SubjectRatingEntity findBySubjectIdAndUserId(long subjectId, long userId) {
        final SubjectRatingEntity exampleEntity = new SubjectRatingEntity();
        exampleEntity.subjectId = subjectId;
        exampleEntity.userId = userId;
        final Example<SubjectRatingEntity> example = Example.of(exampleEntity);
        return subjectRatingRepository
                .findOne(example)
                .orElseThrow(() -> new RecordNotFoundException("Subject Rating"));
    }
}
