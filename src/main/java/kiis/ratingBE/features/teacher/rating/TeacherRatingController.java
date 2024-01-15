package kiis.ratingBE.features.teacher.rating;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping(path = "/teacher-rating")
@RestController
public class TeacherRatingController {
//    private final CrudService<TeacherRatingEntity> teacherRatingCrudService;
//    private final UserActionService<TeacherRatingEntity> teacherRatingUserActionService;
//    private final RatingRepository<TeacherRatingEntity, TeacherRatingAverage> teacherRatingRepository;

//    @GetMapping("/findOne")
//    public TeacherRatingEntity findByTeacherIdAndUserId(long teacherId, long userId) {
//        return teacherRatingRepository.findByParentIdAndUserId(teacherId, userId);
//    }
//
//    @GetMapping("/teacherId/{teacherId}")
//    public TeacherRatingAverage findAverageByTeacherId(@PathVariable long teacherId) {
//        return teacherRatingRepository.findAverageByParentId(teacherId);
//    }
//
//    @GetMapping("/userId/{userId}")
//    public TeacherRatingAverage findAverageByUserId(@PathVariable long userId) {
//        return teacherRatingRepository.findAverageByUserId(userId);
//    }
//
//    @PostMapping
//    public TeacherRatingEntity create(@RequestBody TeacherRatingEntity entity) {
//        return teacherRatingUserActionService.create(entity);
//    }
//
//    @PutMapping("/{id}")
//    public TeacherRatingEntity update(@RequestBody TeacherRatingEntity entity, @PathVariable long id) {
//        return teacherRatingUserActionService.update(entity, id);
//    }
//
//    @DeleteMapping("/{id}")
//    public TeacherRatingEntity delete(@PathVariable long id) {
//        return teacherRatingCrudService.delete(id);
//    }
}