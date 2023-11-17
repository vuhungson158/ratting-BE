package kiis.ratingBE.features.teacher.base;

import kiis.ratingBE.common.CommonRepository;
import kiis.ratingBE.common.join.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherJoinService
        extends JoinService<TeacherEntity, TeacherJoinField> {
    @Autowired
    public TeacherJoinService(CommonRepository<TeacherEntity> joinRepository) {
        super(joinRepository);
    }
}
