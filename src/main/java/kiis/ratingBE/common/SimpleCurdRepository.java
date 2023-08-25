package kiis.ratingBE.common;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SimpleCurdRepository<T extends BaseEntity> extends JpaRepository<T, Long> {

    List<T> findAllByIsDeletedIsFalse();

    Page<T> findAllByIsDeletedIsFalse(Pageable pageable);

    <S extends T> @NotNull Page<S> findAllByIsDeletedIsFalse(@NotNull Example<S> example, @NotNull Pageable pageable);
}
