package kiis.ratingBE.features.teacher.base;

import com.cosium.spring.data.jpa.entity.graph.domain2.DynamicEntityGraph;
import com.cosium.spring.data.jpa.entity.graph.domain2.EntityGraph;
import kiis.ratingBE.common.crud.CrudService;
import kiis.ratingBE.exception.RecordNotFoundException;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService
        extends CrudService<TeacherEntity>
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
                .findById(id, joinSubjects())
                .orElseThrow(() -> new RecordNotFoundException("Teacher", id));
        teacher.transferSubjects();
        return teacher;
    }

    @Override
    public List<TeacherEntity> findAll() {
        return teacherRepository.findAll();
    }

    @Contract(" -> new")
    private @NotNull EntityGraph joinSubjects() {
        return DynamicEntityGraph.loading(List.of("subjectList"));
    }
}
