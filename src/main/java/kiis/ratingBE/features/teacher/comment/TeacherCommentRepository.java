package kiis.ratingBE.features.teacher.comment;

import kiis.ratingBE.common.comment.CommentRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherCommentRepository extends CommentRepository<TeacherCommentEntity> {

    @Override
    @Query(nativeQuery = true, value = """
            SELECT 1
            """)
    List<TeacherCommentEntity> findPageBy(long teacherId, int page, int limit);

    @Override
    @Query(nativeQuery = true, value = """
            SELECT 1
            """)
    long countBy(long teacherId);
}
