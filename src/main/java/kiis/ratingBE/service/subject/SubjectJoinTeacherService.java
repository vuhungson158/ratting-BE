package kiis.ratingBE.service.subject;

import kiis.ratingBE.common.CommonRepository;
import kiis.ratingBE.common.join.JoinService;
import kiis.ratingBE.enums.foreignKey.ForeignKey;
import kiis.ratingBE.enums.foreignKey.SubjectForeignKey;
import kiis.ratingBE.model.subject.SubjectJoinTeacherEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubjectJoinTeacherService extends JoinService<SubjectJoinTeacherEntity> {
    private final CommonRepository<SubjectJoinTeacherEntity> subjectJoinTeacherRepository;

    @Override
    protected CommonRepository<SubjectJoinTeacherEntity> getJoinRepository() {
        return subjectJoinTeacherRepository;
    }

    @Override
    protected ForeignKey[] getJoinFields() {
        return new ForeignKey[]{SubjectForeignKey.TEACHER};
    }
}
