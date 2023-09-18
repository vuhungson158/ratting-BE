package kiis.ratingBE.features.teacher.rating;

import kiis.ratingBE.common.crud.CrudController;
import kiis.ratingBE.features.teacher.rating.dao.TeacherRatingAverage;
import kiis.ratingBE.features.teacher.rating.dao.TeacherRatingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/teacher-rating")
@RestController
public class TeacherRatingController
        extends CrudController<TeacherRatingEntity>
        implements TeacherRatingEndpoint {

    private final TeacherRatingService teacherRatingService;

    @Autowired
    public TeacherRatingController(TeacherRatingService teacherRatingService) {
        super(teacherRatingService);
        this.teacherRatingService = teacherRatingService;
    }

    @Override
    @GetMapping("/teacherId/{teacherId}")
    public TeacherRatingAverage findAverageByTeacherId(@PathVariable("teacherId") long teacherId) {
        return teacherRatingService.findAverageByTeacherId(teacherId);
    }

    @Override
    @GetMapping("/userId/{userId}")
    public TeacherRatingAverage findAverageByUserId(@PathVariable("userId") long userId) {
        return teacherRatingService.findAverageByUserId(userId);
    }

    @Override
    @GetMapping("/findOne")
    public TeacherRatingEntity findByTeacherIdAndUserId(long teacherId, long userId) {
        return teacherRatingService.findByTeacherIdAndUserId(teacherId, userId);
    }
}
