package kiis.ratingBE.features.subject.base;

import kiis.ratingBE.common.SimpleCurdRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends SimpleCurdRepository<SubjectEntity> {

    @Modifying
    @Query(nativeQuery = true, value = """
            UPDATE subject
            SET disable = :disable
            WHERE teacher_id = :teacherId
            """)
    void updateDisableSubjectByTeacherId(long teacherId, boolean disable);

    @Query(nativeQuery = true, value = """
            select id
            from subject
            where id in (:idList)
            """
    )
    List<Long> findByIdList(@Param("idList") List<Long> idList);

    List<SubjectEntity> findAllByTeacherId(Long teacherId);

    @Override
    @NotNull
    @EntityGraph(attributePaths = {"teacher"})
    List<SubjectEntity> findAll();
}


