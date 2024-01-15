package kiis.ratingBE.service.teacher;

import kiis.ratingBE.model.teacher.TeacherEntity;
import kiis.ratingBE.repository.CommonRepository;
import kiis.ratingBE.service.CrudService;
import kiis.ratingBE.service.CrudServiceTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherCrudService
        extends CrudServiceTemplate<TeacherEntity>
        implements CrudService<TeacherEntity> {
    private final CommonRepository<TeacherEntity> teacherCrudRepository;

    @Override
    protected CommonRepository<TeacherEntity> getCrudRepository() {
        return teacherCrudRepository;
    }
}
