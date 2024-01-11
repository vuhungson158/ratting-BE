package kiis.ratingBE.features.teacher.rating;

import kiis.ratingBE.common.crud.CrudService;
import kiis.ratingBE.common.rating.RatingRepository;
import kiis.ratingBE.common.userAction.UserActionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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