package kiis.ratingBE.features.teacher.rating;

import kiis.ratingBE.common.SimpleCurdController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/teacher-rating")
@RestController
public class TeacherRatingController extends
        SimpleCurdController<TeacherRatingEntity> {

    @Autowired
    public TeacherRatingController(TeacherRatingService teacherRatingService) {
        super(teacherRatingService);
    }
}
