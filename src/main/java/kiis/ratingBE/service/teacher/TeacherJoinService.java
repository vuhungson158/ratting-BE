package kiis.ratingBE.service.teacher;

import kiis.ratingBE.enums.foreignKey.ForeignKey;
import kiis.ratingBE.enums.foreignKey.TeacherForeignKey;
import kiis.ratingBE.model.teacher.TeacherJoinEntity;
import kiis.ratingBE.repository.common.JoinRepository;
import kiis.ratingBE.service.common.JoinService;
import kiis.ratingBE.service.common.JoinServiceTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherJoinService
        extends JoinServiceTemplate<TeacherJoinEntity>
        implements JoinService<TeacherJoinEntity> {
    private final JoinRepository<TeacherJoinEntity> teacherJoinSubjectRepository;

    @Override
    protected JoinRepository<TeacherJoinEntity> getJoinRepository() {
        return teacherJoinSubjectRepository;
    }

    @Override
    protected ForeignKey[] getJoinFields() {
        return new ForeignKey[]{TeacherForeignKey.SUBJECTS};
    }
}
