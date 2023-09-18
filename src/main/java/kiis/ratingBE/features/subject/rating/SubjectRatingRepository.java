package kiis.ratingBE.features.subject.rating;

import kiis.ratingBE.common.CommonRepository;
import kiis.ratingBE.features.subject.rating.model.SubjectRatingAverageProjector;
import kiis.ratingBE.features.subject.rating.model.SubjectRatingEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRatingRepository extends
        CommonRepository<SubjectRatingEntity> {

    @Query(nativeQuery = true, value = """
            SELECT COUNT(*)                as totalRecord,
                   AVG(practicality)       as practicalityAverage,
                   AVG(easy_to_understand) as easyToUnderstandAverage,
                   AVG(star)               as starAverage
            FROM subject_rating
            WHERE subject_id = :subjectId
            GROUP BY subject_id
            """)
    SubjectRatingAverageProjector findAverageBySubjectId(long subjectId);

    @Query(nativeQuery = true, value = """
            SELECT COUNT(*)                as totalRecord,
                   AVG(practicality)       as practicalityAverage,
                   AVG(easy_to_understand) as easyToUnderstandAverage,
                   AVG(star)               as starAverage
            FROM subject_rating
            WHERE user_id = :userId
            GROUP BY user_id
            """)
    SubjectRatingAverageProjector findAverageByUserId(long userId);
}
