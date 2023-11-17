package kiis.ratingBE.common.join;

import kiis.ratingBE.common.BaseEntity;
import org.springframework.data.domain.Page;

public interface Join<T extends BaseEntity, J extends JoinField<T>> {

    T findByIdJoin(long id, J[] joinFields);

    Page<T> findAllJoin(int page, int limit, J[] joinFields);

    Page<T> findAllJoin(T exampleEntity, int page, int limit, J[] joinFields);

}
