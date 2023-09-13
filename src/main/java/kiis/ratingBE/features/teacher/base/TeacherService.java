package kiis.ratingBE.features.teacher.base;

import kiis.ratingBE.common.SimpleCurdService;
import kiis.ratingBE.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static kiis.ratingBE.helper.Util.join;

@Service
public class TeacherService
        extends SimpleCurdService<TeacherEntity>
        implements TeacherEndpoint {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository repository) {
        super(repository);
        this.teacherRepository = repository;
    }

    @Override
    public TeacherEntity findOneJoinSubject(long id) {
        final TeacherEntity teacher = teacherRepository
                .findById(id, join("subjects"))
                .orElseThrow(() -> new RecordNotFoundException("Teacher", id));
        teacher.transferSubjects();
        return teacher;
    }

    @Override
    public List<TeacherEntity> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    protected String[] findByIdJoin() {
        return new String[]{};
    }

    @Override
    protected String[] findAllJoin() {
        return new String[0];
    }

    @Override
    protected String[] savedEntityJoin() {
        return new String[0];
    }
}
