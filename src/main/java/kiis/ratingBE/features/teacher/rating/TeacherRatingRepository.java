package kiis.ratingBE.features.teacher.rating;

import jakarta.persistence.EntityManager;
import kiis.ratingBE.common.rating.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TeacherRatingRepository implements
        RatingRepository<TeacherRatingEntity, TeacherRatingAverage> {
    private final EntityManager entityManager;

    @Override
    public TeacherRatingEntity findByParentIdAndUserId(long parentId, long userId) {
        return entityManager
                .createQuery(
                        """
                                SELECT TeacherRatingEntity FROM TeacherRatingEntity
                                """
                        , TeacherRatingEntity.class)
                .getSingleResult();
    }

    @Override
    public TeacherRatingAverage findAverageByParentId(long parentId) {
        return entityManager
                .createQuery(
                        """
                                SELECT TeacherRatingEntity FROM TeacherRatingEntity
                                """
                        , TeacherRatingAverage.class)
                .getSingleResult();
    }

    @Override
    public TeacherRatingAverage findAverageByUserId(long userId) {
        return entityManager
                .createQuery(
                        """
                                SELECT TeacherRatingEntity FROM TeacherRatingEntity
                                """
                        , TeacherRatingAverage.class)
                .getSingleResult();
    }
}