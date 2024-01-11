package kiis.ratingBE.service.teacher;

import kiis.ratingBE.common.CommonRepository;
import kiis.ratingBE.common.join.JoinService;
import kiis.ratingBE.enums.foreignKey.ForeignKey;
import kiis.ratingBE.enums.foreignKey.TeacherForeignKey;
import kiis.ratingBE.model.teacher.TeacherJoinSubjectEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherJoinSubjectService extends JoinService<TeacherJoinSubjectEntity> {
    private final CommonRepository<TeacherJoinSubjectEntity> teacherJoinSubjectRepository;

    @Override
    protected CommonRepository<TeacherJoinSubjectEntity> getJoinRepository() {
        return teacherJoinSubjectRepository;
    }

    @Override
    protected ForeignKey[] getJoinFields() {
        return new ForeignKey[]{TeacherForeignKey.SUBJECTS};
    }
}
