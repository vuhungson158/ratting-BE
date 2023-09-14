package kiis.ratingBE.features.comment.base;

import kiis.ratingBE.common.Projector;
import kiis.ratingBE.common.CommonRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository
        extends CommonRepository<CommentEntity> {

    @Query("""
            SELECT 1
            """)
    List<Projector> findAll(int page, int limit);
}
