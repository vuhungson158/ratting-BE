package kiis.ratingBE.features.teacher.base;

import kiis.ratingBE.common.CrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@AllowFeature(TEACHER)
@RestController
@RequestMapping(path = "/teacher")
public class TeacherController
        extends CrudController<TeacherEntity>
        implements TeacherEndpoint {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService service) {
        super(service);
        this.teacherService = service;
    }

    @Override
    @GetMapping("/findOneJoinSubject/{id}")
    public TeacherEntity findOneJoinSubject(@PathVariable long id) {
        return teacherService.findOneJoinSubject(id);
    }

    @Override
    @GetMapping("everyRecords")
    public List<TeacherEntity> findAll() {
        return teacherService.findAll();
    }
}