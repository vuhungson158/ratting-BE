package kiis.ratingBE.features.teacher.rating;

import org.springframework.stereotype.Service;

@Service
public class TeacherRatingService {
//
//    private final TeacherRatingCrudRepository teacherRatingRepository;
//
//    @Autowired
//    public TeacherRatingService(TeacherRatingCrudRepository teacherRatingRepository) {
//        super(teacherRatingRepository);
//        this.teacherRatingRepository = teacherRatingRepository;
//    }
//
//    @Override
//    public TeacherRatingAverage findAverageByTeacherId(long teacherId) {
//        return teacherRatingRepository.findAverageByTeacherId(teacherId).to(TeacherRatingAverage.class);
//    }
//
//    @Override
//    public TeacherRatingAverage findAverageByUserId(long userId) {
//        return teacherRatingRepository.findAverageByUserId(userId).to(TeacherRatingAverage.class);
//    }
//
//    @Override
//    public TeacherRatingEntity findByTeacherIdAndUserId(long teacherId, long userId) {
//        final TeacherRatingEntity exampleEntity = new TeacherRatingEntity();
//        exampleEntity.teacherId = teacherId;
//        exampleEntity.userId = userId;
//        final Example<TeacherRatingEntity> example = Example.of(exampleEntity);
//        return teacherRatingRepository
//                .findOne(example)
//                .orElseThrow(() -> new RecordNotFoundException("Teacher Rating"));
//    }
}
