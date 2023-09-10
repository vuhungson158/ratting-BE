package kiis.ratingBE.features.subject.rating;

import com.cosium.spring.data.jpa.entity.graph.domain2.EntityGraph;
import kiis.ratingBE.common.SimpleCurdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectRatingService extends
        SimpleCurdService<SubjectRatingEntity> {

    @Autowired
    public SubjectRatingService(SubjectRatingRepository subjectRatingRepository) {
        super(subjectRatingRepository);
    }

    @Override
    protected EntityGraph defaultEntityGraph() {
        return EntityGraph.NOOP;
    }
}