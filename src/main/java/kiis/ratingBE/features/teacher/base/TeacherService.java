package kiis.ratingBE.features.teacher.base;

import kiis.ratingBE.common.join.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService
        extends JoinService<TeacherEntity, TeacherJoinField>
        implements TeacherEndpoint {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository repository) {
        super(repository);
        this.teacherRepository = repository;
    }

    @Override
    public List<TeacherEntity> findAll() {
        return teacherRepository.findAll();
    }
}
