package kiis.ratingBE.features.teacher.rating;

import kiis.ratingBE.common.Projector;
import kiis.ratingBE.common.crud.CrudService;
import kiis.ratingBE.features.teacher.rating.dao.TeacherRatingAverage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherRatingService
        extends CrudService<TeacherRatingEntity>
        implements TeacherRatingEndpoint {

    private final TeacherRatingRepository teacherRatingRepository;

    @Autowired
    public TeacherRatingService(TeacherRatingRepository teacherRatingRepository) {
        super(teacherRatingRepository);
        this.teacherRatingRepository = teacherRatingRepository;
    }

    @Override
    public TeacherRatingAverage findAverageByTeacherId(long teacherId) {
        final Projector queryResult = teacherRatingRepository.findAverageByTeacherId(teacherId);
        return queryResult.to(TeacherRatingAverage.class);
    }

    @Override
    public TeacherRatingAverage findAverageByUserId(long userId) {
        return null;
    }

    @Override
    public TeacherRatingEntity findByTeacherIdAndUserId(long teacherId, long userId) {
        return null;
    }
}
