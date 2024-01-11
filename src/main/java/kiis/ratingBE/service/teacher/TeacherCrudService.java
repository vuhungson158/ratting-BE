package kiis.ratingBE.service.teacher;

import kiis.ratingBE.common.CommonRepository;
import kiis.ratingBE.common.crud.CrudService;
import kiis.ratingBE.model.teacher.TeacherEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherCrudService extends CrudService<TeacherEntity> {
    private final CommonRepository<TeacherEntity> crudRepository;

    @Override
    protected CommonRepository<TeacherEntity> getCrudRepository() {
        return crudRepository;
    }
}
