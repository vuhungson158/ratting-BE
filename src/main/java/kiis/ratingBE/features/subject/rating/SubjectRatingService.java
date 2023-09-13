package kiis.ratingBE.features.subject.rating;

import com.cosium.spring.data.jpa.entity.graph.domain2.EntityGraph;
import kiis.ratingBE.common.SimpleCurdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectRatingService
        extends SimpleCurdService<SubjectRatingEntity>
        implements SubjectRatingEndpoint {

    @Autowired
    public SubjectRatingService(SubjectRatingRepository subjectRatingRepository) {
        super(subjectRatingRepository);
    }

    @Override
    protected EntityGraph defaultEntityGraph() {
        return EntityGraph.NOOP;
    }

    @Override
    protected SubjectRatingEntity findSavedEntityJoin(long id) {
        return null;
    }

    @Override
    public List<SubjectRatingEntity> findAverageBySubjectId(long subjectId) {
        return null;
    }

    @Override
    public List<SubjectRatingEntity> findAverageByUserId(long userId) {
        return null;
    }

    @Override
    public SubjectRatingEntity findBySubjectIdAndUserId(long subjectId, long userId) {
        return null;
    }
}
