package kiis.ratingBE.features.subject.base;

import kiis.ratingBE.common.SimpleCurdController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/subject")
@RestController
//@AllowFeature(SUBJECT)
public class SubjectController extends SimpleCurdController<SubjectEntity> {

    @Autowired
    public SubjectController(SubjectService subjectService) {
        super(subjectService);
    }
}
