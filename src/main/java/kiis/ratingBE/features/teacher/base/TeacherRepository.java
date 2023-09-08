package kiis.ratingBE.features.teacher.base;

import com.cosium.spring.data.jpa.entity.graph.domain2.EntityGraph;
import kiis.ratingBE.common.SimpleCurdRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends SimpleCurdRepository<TeacherEntity> {

    @Override
    @NotNull
    Optional<TeacherEntity> findById(@NotNull Long id);

    @Override
    Optional<TeacherEntity> findById(Long id, EntityGraph entityGraph);
}