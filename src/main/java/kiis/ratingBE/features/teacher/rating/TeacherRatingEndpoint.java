package kiis.ratingBE.features.teacher.rating;

import java.util.List;

public interface TeacherRatingEndpoint {
    List<TeacherRatingEntity> findAverageByTeacherId(long teacherId);

    List<TeacherRatingEntity> findAverageByUserId(long userId);

    TeacherRatingEntity findByTeacherIdAndUserId(long teacherId, long userId);
}
