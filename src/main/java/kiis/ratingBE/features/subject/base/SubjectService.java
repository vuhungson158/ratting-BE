package kiis.ratingBE.features.subject.base;

import kiis.ratingBE.common.crud.CrudService;
import kiis.ratingBE.common.join.JoinService;
import kiis.ratingBE.features.teacher.base.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService
        extends JoinService<SubjectEntity, SubjectJoinField>
        implements SubjectEndpoint {

    @Autowired
    public SubjectService(SubjectRepository subjectRepository,
                          TeacherRepository teacherRepository) {
        super(subjectRepository);
    }
}
