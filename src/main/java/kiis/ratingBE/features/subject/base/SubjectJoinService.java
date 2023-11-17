package kiis.ratingBE.features.subject.base;

import kiis.ratingBE.common.CommonRepository;
import kiis.ratingBE.common.join.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectJoinService
        extends JoinService<SubjectEntity, SubjectJoinField> {

    @Autowired
    public SubjectJoinService(CommonRepository<SubjectEntity> joinRepository) {
        super(joinRepository);
    }

}
