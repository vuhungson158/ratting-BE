package kiis.ratingBE.features.subject.base;

import com.cosium.spring.data.jpa.entity.graph.domain2.DynamicEntityGraph;
import com.cosium.spring.data.jpa.entity.graph.domain2.EntityGraph;
import kiis.ratingBE.common.SimpleCurdService;
import kiis.ratingBE.features.teacher.base.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService extends SimpleCurdService<SubjectEntity> {

    private final SubjectRepository subjectRepository;
    private final TeacherRepository teacherRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository,
                          TeacherRepository teacherRepository) {
        super(subjectRepository);
        this.subjectRepository = subjectRepository;
        this.teacherRepository = teacherRepository;
    }

    public List<SubjectEntity> findAll() {
        return subjectRepository.findAllByIsDeletedIsFalse();
    }

    @Override
    protected EntityGraph defaultEntityGraph() {
        return DynamicEntityGraph.loading(List.of("teacher"));
    }
}
