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
        return (SubjectRatingEntity) entityManager.createQuery("SELECT SubjectCommentEntity FROM SubjectCommentEntity");
    }

    @Override
    public SubjectRatingAverage findAverageByParentId(long parentId) {
        return (SubjectRatingAverage) entityManager.createQuery("SELECT SubjectCommentEntity FROM SubjectCommentEntity");
    }

    @Override
    public SubjectRatingAverage findAverageByUserId(long userId) {
        return (SubjectRatingAverage) entityManager.createQuery("SELECT SubjectCommentEntity FROM SubjectCommentEntity");
    }
}
