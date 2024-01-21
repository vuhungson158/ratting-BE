package kiis.ratingBE.service.subject;

import kiis.ratingBE.enums.foreignKey.ForeignKey;
import kiis.ratingBE.enums.foreignKey.SubjectForeignKey;
import kiis.ratingBE.model.subject.SubjectJoinTeacherEntity;
import kiis.ratingBE.repository.common.JoinRepository;
import kiis.ratingBE.service.common.JoinService;
import kiis.ratingBE.service.common.JoinServiceTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubjectJoinTeacherService
        extends JoinServiceTemplate<SubjectJoinTeacherEntity>
        implements JoinService<SubjectJoinTeacherEntity> {
    private final JoinRepository<SubjectJoinTeacherEntity> subjectJoinTeacherRepository;

    @Override
    protected JoinRepository<SubjectJoinTeacherEntity> getJoinRepository() {
        return subjectJoinTeacherRepository;
    }

    @Override
    protected ForeignKey[] getJoinFields() {
        return new ForeignKey[]{SubjectForeignKey.TEACHER};
    }
}
