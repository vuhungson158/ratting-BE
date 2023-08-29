package kiis.ratingBE.features.teacher.base;

import kiis.ratingBE.common.SimpleCurdService;
import kiis.ratingBE.features.subject.base.SubjectEntity;
import kiis.ratingBE.features.subject.base.SubjectRepository;
import kiis.ratingBE.features.subject.base.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class TeacherService extends SimpleCurdService<TeacherEntity> {
    private final SubjectRepository subjectRepository;
    private final SubjectService subjectService;

    @Autowired
    public TeacherService(TeacherRepository repository,
                          SubjectRepository subjectRepository, SubjectService subjectService) {
        super(repository);
        this.subjectRepository = subjectRepository;
        this.subjectService = subjectService;
    }

    @Override
    public TeacherEntity findById(long id) {
        final TeacherEntity teacher = super.findById(id);

        final SubjectEntity exampleSubject = new SubjectEntity();
        exampleSubject.teacherId = teacher.id;
        exampleSubject.isDeleted = false;

        teacher.subjectList = subjectService
                .findAll(exampleSubject, 0, 10)
                .stream()
                .peek(subject -> subject.teacher = null)
                .toList();
        return teacher;
    }
}
