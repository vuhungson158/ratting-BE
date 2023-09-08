package kiis.ratingBE.features.teacher.base;

import com.cosium.spring.data.jpa.entity.graph.domain2.NamedEntityGraph;
import kiis.ratingBE.common.SimpleCurdService;
import kiis.ratingBE.exception.RecordNotFoundException;
import kiis.ratingBE.features.subject.base.SubjectRepository;
import kiis.ratingBE.features.subject.base.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService extends SimpleCurdService<TeacherEntity> {
    private final TeacherRepository teacherRepository;
    private final SubjectRepository subjectRepository;
    private final SubjectService subjectService;

    @Autowired
    public TeacherService(TeacherRepository repository,
                          SubjectRepository subjectRepository,
                          SubjectService subjectService) {
        super(repository);
        this.teacherRepository = repository;
        this.subjectRepository = subjectRepository;
        this.subjectService = subjectService;
    }

    @Override
    public TeacherEntity findById(long id) {
        final TeacherEntity teacher = super.findById(id);
//        teacher.transferSubjects();
        return teacher;
    }

    public TeacherEntity findOneJoinSubject(long id) {
        final TeacherEntity teacher = teacherRepository
                .findById(id, NamedEntityGraph.loading("subjectList"))
                .orElseThrow(() -> new RecordNotFoundException("Teacher", id));
        teacher.transferSubjects();
        return teacher;
    }

    @Override
    protected void validate(TeacherEntity returnEntity) {

    }
}
