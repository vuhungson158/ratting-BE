package kiis.ratingBE.features.subject.base;

import kiis.ratingBE.aop.AllowFeature;
import kiis.ratingBE.common.crud.CrudController;
import kiis.ratingBE.common.crud.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static kiis.ratingBE.enums.UserRole.Feature.SUBJECT;

@RequestMapping(path = "/subject-crud")
@RestController
@AllowFeature(SUBJECT)
public class SubjectCrudController
        extends CrudController<SubjectEntity> {
    @Autowired
    public SubjectCrudController(CrudService<SubjectEntity> crudService) {
        super(crudService);
    }
}
