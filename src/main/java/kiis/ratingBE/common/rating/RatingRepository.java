package kiis.ratingBE.common.rating;

public interface RatingRepository<RatingEntity extends RatingBaseEntity, RatingAverage extends RatingAverageBase> {
    RatingEntity findByParentIdAndUserId(long parentId, long userId);

    RatingAverage findAverageByParentId(long parentId);

    RatingAverage findAverageByUserId(long userId);
}
