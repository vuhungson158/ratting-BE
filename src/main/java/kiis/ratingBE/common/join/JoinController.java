package kiis.ratingBE.common.join;

import kiis.ratingBE.aop.AllowMethod;
import kiis.ratingBE.common.BaseEntity;
import kiis.ratingBE.common.crud.CrudController;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import static kiis.ratingBE.enums.UserRole.Method.FIND_BY_FILTER;
import static kiis.ratingBE.enums.UserRole.Method.FIND_BY_ID;
import static kiis.ratingBE.enums.UserRole.Method.FIND_BY_PAGEABLE;

public class JoinController<T extends BaseEntity, J extends JoinField<T>>
        extends CrudController<T>
        implements Join<T, J> {

    private final JoinService<T, J> mainService;

    public JoinController(JoinService<T, J> mainService) {
        super(mainService);
        this.mainService = mainService;
    }

    @Override
    @GetMapping("/join/{id}")
    @AllowMethod(FIND_BY_ID)
    public T findByIdJoin(@PathVariable long id, J[] joinFields) {
        return mainService.findByIdJoin(id, joinFields);
    }

    @Override
    @GetMapping("/join")
    @AllowMethod(FIND_BY_PAGEABLE)
    public Page<T> findAllJoin(int page, int limit, J[] joinFields) {
        return mainService.findAllJoin(page, limit, joinFields);
    }

    @Override
    @PostMapping("/join/filter")
    @AllowMethod(FIND_BY_FILTER)
    public Page<T> findAllJoin(T exampleEntity, int page, int limit, J[] joinFields) {
        return mainService.findAllJoin(exampleEntity, page, limit, joinFields);
    }
}
