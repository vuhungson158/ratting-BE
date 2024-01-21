package kiis.ratingBE.service.subject;

import kiis.ratingBE.enums.foreignKey.ForeignKey;
import kiis.ratingBE.enums.foreignKey.SubjectForeignKey;
import kiis.ratingBE.model.subject.SubjectJoinEntity;
import kiis.ratingBE.repository.common.JoinRepository;
import kiis.ratingBE.service.common.JoinService;
import kiis.ratingBE.service.common.JoinServiceTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubjectJoinService
        extends JoinServiceTemplate<SubjectJoinEntity>
        implements JoinService<SubjectJoinEntity> {
    private final JoinRepository<SubjectJoinEntity> subjectJoinTeacherRepository;

    @Override
    protected JoinRepository<SubjectJoinEntity> getJoinRepository() {
        return subjectJoinTeacherRepository;
    }

    @Override
    protected ForeignKey[] getJoinFields() {
        return new ForeignKey[]{SubjectForeignKey.TEACHER};
    }
}
