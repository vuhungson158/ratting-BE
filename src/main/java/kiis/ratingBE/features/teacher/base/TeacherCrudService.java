package kiis.ratingBE.features.teacher.base;

import kiis.ratingBE.common.CommonRepository;
import kiis.ratingBE.common.crud.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherCrudService
        extends CrudService<TeacherEntity> {
    @Autowired
    public TeacherCrudService(CommonRepository<TeacherEntity> crudRepository) {
        super(crudRepository);
    }
}
