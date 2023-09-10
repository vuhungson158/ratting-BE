package kiis.ratingBE.features.comment.base;

import com.cosium.spring.data.jpa.entity.graph.domain2.EntityGraph;
import kiis.ratingBE.common.SimpleCurdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService extends
        SimpleCurdService<CommentEntity> {

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        super(commentRepository);
    }

    @Override
    protected EntityGraph defaultEntityGraph() {
        return EntityGraph.NOOP;
    }
}
