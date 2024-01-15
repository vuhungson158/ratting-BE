package kiis.ratingBE.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/user")
public class UserController {
//    private final CrudServiceTemplate<UserEntity> userCrudService;


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
