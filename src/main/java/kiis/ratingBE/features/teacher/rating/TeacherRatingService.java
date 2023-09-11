package kiis.ratingBE.features.teacher.rating;

import com.cosium.spring.data.jpa.entity.graph.domain2.EntityGraph;
import kiis.ratingBE.common.SimpleCurdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherRatingService
        extends SimpleCurdService<TeacherRatingEntity>
        implements TeacherRatingEndpoint {

    @Autowired
    public TeacherRatingService(TeacherRatingRepository teacherRatingRepository) {
        super(teacherRatingRepository);
    }

    @Override
    protected EntityGraph defaultEntityGraph() {
        return EntityGraph.NOOP;
    }

    @Override
    public List<TeacherRatingEntity> findAverageByTeacherId(long teacherId) {
        return null;
    }

    @Override
    public List<TeacherRatingEntity> findAverageByUserId(long userId) {
        return null;
    }

    @Override
    public TeacherRatingEntity getByTeacherIdAndUserId(long teacherId, long userId) {
        return null;
    }
}
