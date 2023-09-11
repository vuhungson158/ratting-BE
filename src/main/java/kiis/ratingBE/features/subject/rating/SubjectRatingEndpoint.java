package kiis.ratingBE.features.subject.rating;

import java.util.List;

public interface SubjectRatingEndpoint {
    List<SubjectRatingEntity> findAverageBySubjectId(long subjectId);

    List<SubjectRatingEntity> findAverageByUserId(long userId);

    SubjectRatingEntity findBySubjectIdAndUserId(long subjectId, long userId);
}
