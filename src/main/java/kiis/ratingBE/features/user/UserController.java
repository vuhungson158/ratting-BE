package kiis.ratingBE.features.user;

import kiis.ratingBE.common.crud.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/user")
public class UserController {
//    private final CrudService<UserEntity> userCrudService;


//    @GetMapping("/{id}")
//    public UserEntity findById(@PathVariable long id) {
//        return userCrudService.findById(id);
//    }
//
//    @PostMapping
//    public UserEntity create(@RequestBody UserEntity entity) {
//        return userCrudService.create(entity);
//    }
//
//    @PutMapping("/{id}")
//    public UserEntity update(@RequestBody UserEntity entity, @PathVariable long id) {
//        return userCrudService.update(entity, id);
//    }
//
//    @DeleteMapping("/{id}")
//    public UserEntity delete(@PathVariable long id) {
//        return userCrudService.delete(id);
//    }
}
