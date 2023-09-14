package kiis.ratingBE.common;

import org.springframework.data.domain.Page;

public interface Join<T extends BaseEntity, J extends JoinField<T>>
        extends Crud<T> {

    T findByIdJoin(long id, J[] joinFields);

    Page<T> findAllJoin(int page, int limit, J[] joinFields);

    Page<T> findAllJoin(T exampleEntity, int page, int limit, J[] joinFields);

}
