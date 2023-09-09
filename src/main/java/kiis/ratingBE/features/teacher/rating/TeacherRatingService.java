package kiis.ratingBE.features.teacher.rating;

import com.cosium.spring.data.jpa.entity.graph.domain2.EntityGraph;
import kiis.ratingBE.common.SimpleCurdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherRatingService extends
        SimpleCurdService<TeacherRatingEntity> {

    @Autowired
    public TeacherRatingService(TeacherRatingRepository teacherRatingRepository) {
        super(teacherRatingRepository);
    }

    @Override
    protected EntityGraph defaultEntityGraph() {
        return EntityGraph.NOOP;
    }
}
