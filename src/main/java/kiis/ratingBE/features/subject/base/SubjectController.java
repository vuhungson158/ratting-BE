package kiis.ratingBE.features.subject.base;

import kiis.ratingBE.common.SimpleCurdController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(path = "/subject")
@RestController
//@AllowFeature(SUBJECT)
public class SubjectController
        extends SimpleCurdController<SubjectEntity>
        implements SubjectEndpoint {

    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        super(subjectService);
        this.subjectService = subjectService;
    }

    @Override
    @GetMapping("/all")
    public List<SubjectEntity> findAll() {
        return subjectService.findAll();
    }
}
