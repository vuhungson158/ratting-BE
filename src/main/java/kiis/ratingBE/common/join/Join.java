package kiis.ratingBE.common.join;

import kiis.ratingBE.common.BaseEntity;
import org.springframework.data.domain.Page;

public interface Join<Entity extends BaseEntity, FieldEnum extends JoinField<Entity>> {
    Entity findByIdJoin(long id, FieldEnum[] joinFields);

    Page<Entity> findAllJoin(int page, int limit, FieldEnum[] joinFields);

    Page<Entity> findAllJoin(Entity exampleEntity, int page, int limit, FieldEnum[] joinFields);
}
