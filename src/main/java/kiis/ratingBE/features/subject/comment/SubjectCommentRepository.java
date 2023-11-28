package kiis.ratingBE.features.subject.comment;

import kiis.ratingBE.common.comment.CommentRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectCommentRepository extends CommentRepository<SubjectCommentEntity> {

    @Override
    @Query(nativeQuery = true, value = """
            SELECT 1
            """)
    List<SubjectCommentEntity> findPageBy(long subjectId, int page, int limit);

    @Override
    @Query(nativeQuery = true, value = """
            SELECT 1
            """)
    long countBy(long subjectId);
}
