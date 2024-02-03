package kiis.ratingBE.repository.subject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaUpdate;
import kiis.ratingBE.model.subject.SubjectEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SubjectManualRepository {
    private final EntityManager entityManager;

    public void deleteByTeacherId(Long teacherId) {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaUpdate<SubjectEntity> updateQuery = criteriaBuilder.createCriteriaUpdate(SubjectEntity.class);
        updateQuery.set(updateQuery.getRoot().get("isDeleted"), true);
        updateQuery.where(criteriaBuilder.equal(updateQuery.getRoot().get("teacherId"), teacherId));
        entityManager.createQuery(updateQuery).executeUpdate();
    }
}
