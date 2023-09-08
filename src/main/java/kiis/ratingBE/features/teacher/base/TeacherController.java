package kiis.ratingBE.features.teacher.base;

import kiis.ratingBE.common.SimpleCurdController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@AllowFeature(TEACHER)
//@AllArgsConstructor
@RestController
@RequestMapping(path = "/teacher")
public class TeacherController extends SimpleCurdController<TeacherEntity> {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService service) {
        super(service);
        this.teacherService = service;
    }

    @GetMapping("/findOneJoinSubject/{id}")
    public TeacherEntity findOneJoinSubject(@PathVariable long id) {
        return teacherService.findOneJoinSubject(id);
    }
}

//    private final TeacherRepository teacherRepository;
//    private final SubjectRepository subjectRepository;
//    private final UserRepository userRepository;
//
//    @GetMapping("/{id}")
//    public TeacherEntity getById(@PathVariable long id) {
//        return teacherRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("No Teacher with Id: " + id));
//    }
//
//    @GetMapping("")
//    public List<TeacherEntity> getAllEnable() {
//        return teacherRepository.findAllByIsDeleted(false);
//    }
//
//    @GetMapping("/all")
//    @AllowMethod(FIND_ALL)
//    public List<TeacherEntity> getAll() {
//        return teacherRepository.findAll();
//    }
//
//    @PostMapping("")
//    public void create(@RequestBody TeacherRequest request) {
//        teacherRepository.save(request.toEntity());
//    }
//
//    @PutMapping("/{id}")
//    public void update(@PathVariable long id, @RequestBody TeacherRequest request) {
//        if (!teacherRepository.existsById(id))
//            throw new IllegalArgumentException("No Teacher with ID:" + id);
//        TeacherEntity teacherEntity = request.toEntity();
//        teacherEntity.id = id;
//        teacherRepository.save(teacherEntity);
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable long id) {
//        TeacherEntity teacherEntity = teacherRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("No Teacher with Id: " + id));
//        subjectRepository.updateDisableSubjectByTeacherId(id, true);
//        teacherEntity.isDeleted = true;
//        teacherRepository.save(teacherEntity);
//    }
//
//    @AllArgsConstructor
//    private static class TeacherRequest extends TeacherEntity {
//        private long id;
//        private Instant createdAt, updatedAt;
//        private boolean disable;
//
//        public TeacherEntity toEntity() {
//            return Util.mapping(this, TeacherEntity.class);
//        }
//    }
//}
