package kiis.ratingBE.features.subject.rating;

import kiis.ratingBE.common.SimpleCurdRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRatingRepository extends
        SimpleCurdRepository<SubjectRatingEntity> {
}
