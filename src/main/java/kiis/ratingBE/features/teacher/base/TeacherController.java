package kiis.ratingBE.features.teacher.base;

import kiis.ratingBE.aop.AllowFeature;
import kiis.ratingBE.aop.AllowRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static kiis.ratingBE.enums.UserRole.ADMIN;
import static kiis.ratingBE.enums.UserRole.Feature.TEACHER;

@AllowFeature(TEACHER)
@RestController
@RequestMapping(path = "/teacher")
public class TeacherController
        implements TeacherEndpoint {
    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Override
    @GetMapping("/everyRecords")
    public List<TeacherEntity> findAll() {
        return teacherService.findAll();
    }
}
