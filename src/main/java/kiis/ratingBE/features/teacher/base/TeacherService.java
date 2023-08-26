package kiis.ratingBE.features.teacher.base;

import kiis.ratingBE.common.SimpleCurdService;
import kiis.ratingBE.features.subject.base.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService extends SimpleCurdService<TeacherEntity> {
    private final SubjectRepository subjectRepository;

    @Autowired
    public TeacherService(TeacherRepository repository,
                          SubjectRepository subjectRepository) {
        super(repository);
        this.subjectRepository = subjectRepository;
    }

    @Override
    public TeacherEntity findById(long id) {
        final TeacherEntity teacher = super.findById(id);
        teacher.subjectList = subjectRepository.findAllByTeacherId(teacher.id);
        return teacher;
    }
}
