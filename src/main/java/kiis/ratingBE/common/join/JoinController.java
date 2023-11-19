package kiis.ratingBE.common.join;

import kiis.ratingBE.aop.AllowMethod;
import kiis.ratingBE.common.BaseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import static kiis.ratingBE.enums.UserRole.Method.FIND_BY_FILTER;
import static kiis.ratingBE.enums.UserRole.Method.FIND_BY_ID;
import static kiis.ratingBE.enums.UserRole.Method.FIND_BY_PAGEABLE;

@RequiredArgsConstructor
public abstract class JoinController<Entity extends BaseEntity, FieldEnum extends JoinField<Entity>>
        implements Join<Entity, FieldEnum> {
    private final JoinService<Entity, FieldEnum> joinService;

    @Override
    @GetMapping("/join/{id}")
    @AllowMethod(FIND_BY_ID)
    public Entity findByIdJoin(@PathVariable long id, FieldEnum[] joinFields) {
        return joinService.findByIdJoin(id, joinFields);
    }

    @Override
    @GetMapping("/join")
    @AllowMethod(FIND_BY_PAGEABLE)
    public Page<Entity> findAllJoin(int page, int limit, FieldEnum[] joinFields) {
        return joinService.findAllJoin(page, limit, joinFields);
    }

    @Override
    @PostMapping("/join/filter")
    @AllowMethod(FIND_BY_FILTER)
    public Page<Entity> findAllJoin(Entity exampleEntity, int page, int limit, FieldEnum[] joinFields) {
        return joinService.findAllJoin(exampleEntity, page, limit, joinFields);
    }
}
