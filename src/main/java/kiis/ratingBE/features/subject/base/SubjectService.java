package kiis.ratingBE.features.subject.base;

import kiis.ratingBE.common.crud.CrudService;
import kiis.ratingBE.features.teacher.base.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService
        extends CrudService<SubjectEntity>
        implements SubjectEndpoint {

    @Autowired
    public SubjectService(SubjectRepository subjectRepository,
                          TeacherRepository teacherRepository) {
        super(subjectRepository);
    }

    @Override
    protected SubjectEntity findSavedEntityJoin(long id) {
        return null;
    }
}
