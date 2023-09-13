package kiis.ratingBE.features.comment.react;

import com.cosium.spring.data.jpa.entity.graph.domain2.EntityGraph;
import kiis.ratingBE.common.SimpleCurdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReactService extends
        SimpleCurdService<ReactEntity> {

    @Autowired
    public ReactService(ReactRepository reactRepository) {
        super(reactRepository);
    }

    @Override
    protected EntityGraph defaultEntityGraph() {
        return EntityGraph.NOOP;
    }

    @Override
    protected ReactEntity findSavedEntityJoin(long id) {
        return null;
    }
}
