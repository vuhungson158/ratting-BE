package kiis.ratingBE.features.subject.rating;

import kiis.ratingBE.features.subject.rating.model.SubjectRatingAverage;
import kiis.ratingBE.features.subject.rating.model.SubjectRatingEntity;

public interface SubjectRatingEndpoint {
    SubjectRatingAverage findAverageBySubjectId(long subjectId);

    SubjectRatingAverage findAverageByUserId(long userId);

    SubjectRatingEntity findBySubjectIdAndUserId(long subjectId, long userId);
}
