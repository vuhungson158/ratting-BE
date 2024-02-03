package kiis.ratingBE.service.teacher;

import jakarta.transaction.Transactional;
import kiis.ratingBE.model.teacher.TeacherEntity;
import kiis.ratingBE.repository.common.CommonRepository;
import kiis.ratingBE.repository.subject.SubjectManualRepository;
import kiis.ratingBE.repository.subject.SubjectRepository;
import kiis.ratingBE.service.common.CrudService;
import kiis.ratingBE.service.common.CrudServiceTemplate;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherCrudService
        extends CrudServiceTemplate<TeacherEntity>
        implements CrudService<TeacherEntity> {
    private final CommonRepository<TeacherEntity> teacherCrudRepository;
    private final SubjectManualRepository subjectManualRepository;

    @Override
    protected CommonRepository<TeacherEntity> getCrudRepository() {
        return teacherCrudRepository;
    }

    @Override
    @Transactional
    public @NotNull TeacherEntity delete(long id) {
        subjectManualRepository.deleteByTeacherId(id);
        return super.delete(id);
    }
}
