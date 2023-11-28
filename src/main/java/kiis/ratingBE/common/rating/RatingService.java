package kiis.ratingBE.common.rating;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class RatingService<RatingEntity extends RatingBaseEntity, RatingAverage extends RatingAverageBase> {
    private final RatingRepository<RatingEntity, RatingAverage> ratingRepository;

//    public RatingAverage findAverageByParentId(long parentId) {
//        return ratingRepository
//                .findAverageBySubjectId(subjectId)
//                .to(RatingAverage.class);
//    }
//
//    public RatingAverage findAverageByUserId(long userId) {
//        return subjectRatingRepository
//                .findAverageByUserId(userId)
//                .to(RatingAverage.class);
//    }
//
//    public RatingEntity findBySubjectIdAndUserId(long subjectId, long userId) {
//        final RatingEntity exampleEntity = new RatingEntity();
//        exampleEntity.subjectId = subjectId;
//        exampleEntity.userId = userId;
//        final Example<RatingEntity> example = Example.of(exampleEntity);
//        return subjectRatingRepository
//                .findOne(example)
//                .orElseThrow(() -> new RecordNotFoundException("Subject Rating"));
//    }
}
