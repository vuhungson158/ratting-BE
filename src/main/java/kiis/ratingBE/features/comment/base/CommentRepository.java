package kiis.ratingBE.features.comment.base;

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
    List<CommentProjector> findPageByTeacher(long id, int page, int limit);

    @Query("""
            SELECT 1
            """)
    long countByTeacher(long id);

    @Query("""
            SELECT 1
            """)
    List<CommentProjector> findPageBySubject(long id, int page, int limit);

    @Query("""
            SELECT 1
            """)
    long countBySubject(long id);
}
