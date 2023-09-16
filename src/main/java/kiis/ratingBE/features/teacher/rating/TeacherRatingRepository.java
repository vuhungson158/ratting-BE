package kiis.ratingBE.features.teacher.rating;

import kiis.ratingBE.common.CommonRepository;
import kiis.ratingBE.common.Projector;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRatingRepository
        extends CommonRepository<TeacherRatingEntity> {

    @Query(nativeQuery = true, value = """
            SELECT COUNT(*)         as totalRecord,
                   AVG(enthusiasm)  as enthusiasmAverage,
                   AVG(erudition)   as eruditionAverage,
                   AVG(friendly)    as friendlyAverage,
                   AVG(pedagogical) as pedagogicalAverage,
                   AVG(star)        as starAverage
            FROM teacher_rating
            WHERE teacher_id = :teacherId
            GROUP BY teacher_id
            """)
    Projector findAverageByTeacherId(long teacherId);

    @Query(nativeQuery = true, value = """
            SELECT COUNT(*)         as totalRecord,
                   AVG(enthusiasm)  as enthusiasmAverage,
                   AVG(erudition)   as eruditionAverage,
                   AVG(friendly)    as friendlyAverage,
                   AVG(pedagogical) as pedagogicalAverage,
                   AVG(star)        as starAverage
            FROM teacher_rating
            WHERE user_id = :userId
            GROUP BY user_id
            """)
    Projector findAverageByUserId(long userId);
}
