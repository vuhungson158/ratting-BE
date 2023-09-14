package kiis.ratingBE.common.crud;

import kiis.ratingBE.aop.AllowMethod;
import kiis.ratingBE.common.BaseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import static kiis.ratingBE.enums.UserRole.Method.CREATE;
import static kiis.ratingBE.enums.UserRole.Method.DELETE;
import static kiis.ratingBE.enums.UserRole.Method.FIND_BY_FILTER;
import static kiis.ratingBE.enums.UserRole.Method.FIND_BY_ID;
import static kiis.ratingBE.enums.UserRole.Method.FIND_BY_PAGEABLE;
import static kiis.ratingBE.enums.UserRole.Method.UPDATE;

@RequiredArgsConstructor
public abstract class CrudController<T extends BaseEntity>
        implements Crud<T> {

    private final CrudService<T> mainService;

    @Override
    @GetMapping("/{id}")
    @AllowMethod(FIND_BY_ID)
    public T findById(@PathVariable long id) {
        return mainService.findById(id);
    }

    @Override
    @GetMapping
    @AllowMethod(FIND_BY_PAGEABLE)
    public Page<T> findAll(@RequestParam int page, @RequestParam int limit) {
        return mainService.findAll(page, limit);
    }

    @Override
    @PostMapping("/filter")
    @AllowMethod(FIND_BY_FILTER)
    public Page<T> findAll(@RequestBody T exampleEntity, @RequestParam int page, @RequestParam int limit) {
        return mainService.findAll(exampleEntity, page, limit);
    }

    @Override
    @PostMapping
    @AllowMethod(CREATE)
    public T create(@RequestBody T entity) {
        return mainService.create(entity);
    }

    @Override
    @PutMapping("/{id}")
    @AllowMethod(UPDATE)
    public T update(@RequestBody T entity, @PathVariable long id) {
        return mainService.update(entity, id);
    }

    @Override
    @DeleteMapping("/{id}")
    @AllowMethod(DELETE)
    public T delete(@PathVariable long id) {
        return mainService.delete(id);
    }
}
