package kiis.ratingBE.features.subject.rating;

import jakarta.persistence.EntityManager;
import kiis.ratingBE.common.rating.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SubjectRatingRepository implements
        RatingRepository<SubjectRatingEntity, SubjectRatingAverage> {
    private final EntityManager entityManager;

    @Override
    public SubjectRatingEntity findByParentIdAndUserId(long parentId, long userId) {
        return entityManager
                .createQuery(
                        """
                                SELECT SubjectRatingEntity FROM SubjectRatingEntity
                                """
                        , SubjectRatingEntity.class)
                .getSingleResult();
    }

    @Override
    public SubjectRatingAverage findAverageByParentId(long parentId) {
        return entityManager
                .createQuery(
                        """
                                SELECT SubjectRatingEntity FROM SubjectRatingEntity
                                """
                        , SubjectRatingAverage.class)
                .getSingleResult();
    }

    @Override
    public SubjectRatingAverage findAverageByUserId(long userId) {
        return entityManager
                .createQuery(
                        """
                                SELECT SubjectRatingEntity FROM SubjectRatingEntity
                                """
                        , SubjectRatingAverage.class)
                .getSingleResult();
    }
}
