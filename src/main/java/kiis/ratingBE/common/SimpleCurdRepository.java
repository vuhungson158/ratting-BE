package kiis.ratingBE.common;

import com.cosium.spring.data.jpa.entity.graph.domain2.EntityGraph;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface SimpleCurdRepository<T extends BaseEntity> extends
        JpaRepository<T, Long>,
        EntityGraphJpaRepository<T, Long> {

    List<T> findAllByIsDeletedIsFalse();

    Page<T> findAllByIsDeletedIsFalse(Pageable pageable, EntityGraph entityGraph);
}
