package kiis.ratingBE.features.subject.base;

import kiis.ratingBE.aop.AllowFeature;
import kiis.ratingBE.common.join.JoinController;
import kiis.ratingBE.common.join.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static kiis.ratingBE.enums.UserRole.Feature.SUBJECT;

@RequestMapping(path = "/subject-join")
@RestController
@AllowFeature(SUBJECT)
public class SubjectJoinController
        extends JoinController<SubjectEntity, SubjectJoinField> {
    @Autowired
    public SubjectJoinController(JoinService<SubjectEntity, SubjectJoinField> joinService) {
        super(joinService);
    }
}
