package kiis.ratingBE.features.teacher.base;

import kiis.ratingBE.common.SimpleCurdRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends SimpleCurdRepository<TeacherEntity> {

    @Override
//    @EntityGraph(attributePaths = {""})
    Page<TeacherEntity> findAllByIsDeletedIsFalse(Pageable pageable);

    @Override
    @NotNull
    @EntityGraph(attributePaths = {"subjectList"})
    Optional<TeacherEntity> findById(@NotNull Long id);
}