package kiis.ratingBE.features.subject.rating;

import kiis.ratingBE.common.CommonRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRatingRepository extends
        CommonRepository<SubjectRatingEntity> {
}
