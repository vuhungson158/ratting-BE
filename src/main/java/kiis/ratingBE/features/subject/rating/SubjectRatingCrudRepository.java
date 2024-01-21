package kiis.ratingBE.features.subject.rating;

import kiis.ratingBE.repository.common.CommonRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRatingCrudRepository extends CommonRepository<SubjectRatingEntity> {
}
