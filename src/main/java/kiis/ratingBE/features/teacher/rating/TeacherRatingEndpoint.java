package kiis.ratingBE.features.teacher.rating;

import kiis.ratingBE.features.teacher.rating.dao.TeacherRatingAverage;
import kiis.ratingBE.features.teacher.rating.dao.TeacherRatingEntity;

public interface TeacherRatingEndpoint {
    TeacherRatingAverage findAverageByTeacherId(long teacherId);

    TeacherRatingAverage findAverageByUserId(long userId);

    TeacherRatingEntity findByTeacherIdAndUserId(long teacherId, long userId);
}
