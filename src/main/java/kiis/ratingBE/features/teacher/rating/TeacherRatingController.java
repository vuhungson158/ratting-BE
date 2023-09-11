package kiis.ratingBE.features.teacher.rating;

import kiis.ratingBE.common.SimpleCurdController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(path = "/teacher-rating")
@RestController
public class TeacherRatingController
        extends SimpleCurdController<TeacherRatingEntity>
        implements TeacherRatingEndpoint {

    private final TeacherRatingService teacherRatingService;

    @Autowired
    public TeacherRatingController(TeacherRatingService teacherRatingService) {
        super(teacherRatingService);
        this.teacherRatingService = teacherRatingService;
    }

    @Override
    @GetMapping("/teacherId/{teacherId}")
    public List<TeacherRatingEntity> findAverageByTeacherId(@PathVariable("teacherId") long teacherId) {
        return teacherRatingService.findAverageByTeacherId(teacherId);
    }

    @Override
    @GetMapping("/userId/{userId}")
    public List<TeacherRatingEntity> findAverageByUserId(@PathVariable("userId") long userId) {
        return teacherRatingService.findAverageByUserId(userId);
    }

    @Override
    @GetMapping("/findOne")
    public TeacherRatingEntity getByTeacherIdAndUserId(long teacherId, long userId) {
        return teacherRatingService.getByTeacherIdAndUserId(teacherId, userId);
    }
}
