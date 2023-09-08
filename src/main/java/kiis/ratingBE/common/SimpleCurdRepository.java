package kiis.ratingBE.common;

import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SimpleCurdRepository<T extends BaseEntity> extends EntityGraphJpaRepository<T, Long> {

    List<T> findAllByIsDeletedIsFalse();

    Page<T> findAllByIsDeletedIsFalse(Pageable pageable);
}
