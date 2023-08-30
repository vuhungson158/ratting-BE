package kiis.ratingBE.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SimpleCurdRepository<T extends BaseEntity> extends JpaRepository<T, Long> {

    List<T> findAllByIsDeletedIsFalse();

    Page<T> findAllByIsDeletedIsFalse(Pageable pageable);
}
