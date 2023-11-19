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
public abstract class CrudController<Entity extends BaseEntity>
        implements Crud<Entity> {
    private final CrudService<Entity> crudService;

    @Override
    @GetMapping("/{id}")
    @AllowMethod(FIND_BY_ID)
    public Entity findById(@PathVariable long id) {
        return crudService.findById(id);
    }

    @Override
    @GetMapping
    @AllowMethod(FIND_BY_PAGEABLE)
    public Page<Entity> findAll(@RequestParam int page, @RequestParam int limit) {
        return crudService.findAll(page, limit);
    }

    @Override
    @PostMapping("/filter")
    @AllowMethod(FIND_BY_FILTER)
    public Page<Entity> findAll(@RequestBody Entity exampleEntity, @RequestParam int page, @RequestParam int limit) {
        return crudService.findAll(exampleEntity, page, limit);
    }

    @Override
    @PostMapping
    @AllowMethod(CREATE)
    public Entity create(@RequestBody Entity entity) {
        return crudService.create(entity);
    }

    @Override
    @PutMapping("/{id}")
    @AllowMethod(UPDATE)
    public Entity update(@RequestBody Entity entity, @PathVariable long id) {
        return crudService.update(entity, id);
    }

    @Override
    @DeleteMapping("/{id}")
    @AllowMethod(DELETE)
    public Entity delete(@PathVariable long id) {
        return crudService.delete(id);
    }
}
