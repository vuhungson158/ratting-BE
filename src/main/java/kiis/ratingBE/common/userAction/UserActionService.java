package kiis.ratingBE.common.userAction;

import kiis.ratingBE.common.crud.CrudService;
import kiis.ratingBE.features.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;

@RequiredArgsConstructor
public abstract class UserActionService<Entity extends UserActionBaseEntity> {
    private final CrudService<Entity> crudService;
    private final AuthService authService;

    public Entity create(@NotNull Entity entity) {
        entity.userId = authService.getLongingUserId();
        return crudService.create(entity);
    }

    public Entity update(@NotNull Entity entity, long id) {
        entity.userId = authService.getLongingUserId();
        return crudService.update(entity, id);
    }
}
