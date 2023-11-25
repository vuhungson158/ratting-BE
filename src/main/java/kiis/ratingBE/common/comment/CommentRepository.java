package kiis.ratingBE.common.comment;

import kiis.ratingBE.common.CommonRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface CommentRepository
        extends CommonRepository<CommentBaseEntity> {

    @Query(value = """
            SELECT * FROM comment;
            """, nativeQuery = true)
    List<CommentBaseEntity> findPage(long parentId, int page, int limit);

    @Query("""
            SELECT 1
            """)
    long count(long parentId);
}
