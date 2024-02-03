package kiis.ratingBE.repository.subject;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SubjectManualRepository {
    private final EntityManager entityManager;

    public void deleteByTeacherId(Long teacherId) {
        entityManager
                .createNativeQuery("""
                        UPDATE subject
                        SET is_deleted = true
                        WHERE teacher_id = %s
                        """.formatted(teacherId))
                .executeUpdate();
    }
}
