package kiis.ratingBE.common.comment;

import kiis.ratingBE.common.CommonRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface CommentRepository<CommentEntity extends CommentBaseEntity>
        extends CommonRepository<CommentEntity> {

    @Query(value = """
            SELECT * FROM comment;
            """, nativeQuery = true)
    List<CommentEntity> findPage(long parentId, int page, int limit);

    @Query("""
            SELECT 1
            """)
    long count(long parentId);
}
