package kiis.ratingBE.service.teacher;

import kiis.ratingBE.enums.foreignKey.ForeignKey;
import kiis.ratingBE.enums.foreignKey.TeacherForeignKey;
import kiis.ratingBE.model.teacher.TeacherJoinSubjectEntity;
import kiis.ratingBE.repository.common.JoinRepository;
import kiis.ratingBE.service.common.JoinService;
import kiis.ratingBE.service.common.JoinServiceTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherJoinSubjectService
        extends JoinServiceTemplate<TeacherJoinSubjectEntity>
        implements JoinService<TeacherJoinSubjectEntity> {
    private final JoinRepository<TeacherJoinSubjectEntity> teacherJoinSubjectRepository;

    @Override
    protected JoinRepository<TeacherJoinSubjectEntity> getJoinRepository() {
        return teacherJoinSubjectRepository;
    }

    @Override
    protected ForeignKey[] getJoinFields() {
        return new ForeignKey[]{TeacherForeignKey.SUBJECTS};
    }
}
