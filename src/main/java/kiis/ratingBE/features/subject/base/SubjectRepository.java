package kiis.ratingBE.features.subject.base;

import kiis.ratingBE.common.SimpleCurdRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends SimpleCurdRepository<SubjectEntity> {

//    @Override
//    @EntityGraph(attributePaths = {"teacher"})
//    @NotNull List<SubjectEntity> findAll();

    @Override
    @EntityGraph(attributePaths = {"teacher"})
    List<SubjectEntity> findAllByIsDeletedIsFalse();

    @Override
    @EntityGraph(attributePaths = {"teacher"})
    Page<SubjectEntity> findAllByIsDeletedIsFalse(Pageable pageable);

    @Override
    @EntityGraph(attributePaths = {"teacher"})
    <S extends SubjectEntity> @NotNull Page<S> findAll(@NotNull Example<S> example, @NotNull Pageable pageable);
}


