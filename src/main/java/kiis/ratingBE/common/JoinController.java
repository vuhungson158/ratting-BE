package kiis.ratingBE.common;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    public T findByIdJoin(@PathVariable long id, J[] joinFields) {
        return mainService.findByIdJoin(id, joinFields);
    }

    @Override
    @GetMapping("/join")
    public Page<T> findAllJoin(int page, int limit, J[] joinFields) {
        return mainService.findAllJoin(page, limit, joinFields);
    }

    @Override
    @PostMapping("/join/filter")
    public Page<T> findAllJoin(T exampleEntity, int page, int limit, J[] joinFields) {
        return mainService.findAllJoin(exampleEntity, page, limit, joinFields);
    }
}
