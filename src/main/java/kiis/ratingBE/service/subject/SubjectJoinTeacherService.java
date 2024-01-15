package kiis.ratingBE.service.subject;

import kiis.ratingBE.service.JoinService;
import kiis.ratingBE.enums.foreignKey.ForeignKey;
import kiis.ratingBE.enums.foreignKey.SubjectForeignKey;
import kiis.ratingBE.model.subject.SubjectJoinTeacherEntity;
import kiis.ratingBE.repository.JoinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubjectJoinTeacherService extends JoinService<SubjectJoinTeacherEntity> {
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
