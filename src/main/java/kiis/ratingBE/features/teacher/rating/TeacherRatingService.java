package kiis.ratingBE.features.teacher.rating;

import kiis.ratingBE.common.crud.CrudService;
import kiis.ratingBE.exception.RecordNotFoundException;
import kiis.ratingBE.features.teacher.rating.model.TeacherRatingAverage;
import kiis.ratingBE.features.teacher.rating.model.TeacherRatingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
        return teacherRatingRepository.findAverageByTeacherId(teacherId).to(TeacherRatingAverage.class);
    }

    @Override
    public TeacherRatingAverage findAverageByUserId(long userId) {
        return teacherRatingRepository.findAverageByUserId(userId).to(TeacherRatingAverage.class);
    }

    @Override
    public TeacherRatingEntity findByTeacherIdAndUserId(long teacherId, long userId) {
        final TeacherRatingEntity exampleEntity = new TeacherRatingEntity();
        exampleEntity.teacherId = teacherId;
        exampleEntity.userId = userId;
        final Example<TeacherRatingEntity> example = Example.of(exampleEntity);
        return teacherRatingRepository
                .findOne(example)
                .orElseThrow(() -> new RecordNotFoundException("Teacher Rating"));
    }
}
