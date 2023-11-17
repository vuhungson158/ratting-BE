package kiis.ratingBE.features.subject.base;

import kiis.ratingBE.common.CommonRepository;
import kiis.ratingBE.common.crud.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectCrudService
        extends CrudService<SubjectEntity> {
    @Autowired
    public SubjectCrudService(CommonRepository<SubjectEntity> crudRepository) {
        super(crudRepository);
    }
}
