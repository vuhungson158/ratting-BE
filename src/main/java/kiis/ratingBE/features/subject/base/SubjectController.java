package kiis.ratingBE.features.subject.base;

import kiis.ratingBE.aop.AllowFeature;
import kiis.ratingBE.common.crud.CrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static kiis.ratingBE.enums.UserRole.Feature.SUBJECT;

@RequestMapping(path = "/subject")
@RestController
@AllowFeature(SUBJECT)
public class SubjectController
        extends CrudController<SubjectEntity>
        implements SubjectEndpoint {

//    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        super(subjectService);
//        this.subjectService = subjectService;
    }
}
