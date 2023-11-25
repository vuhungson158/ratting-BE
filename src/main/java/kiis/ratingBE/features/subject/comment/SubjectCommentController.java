package kiis.ratingBE.features.subject.comment;

import kiis.ratingBE.common.crud.CrudService;
import kiis.ratingBE.common.userAction.UserActionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/subject-comment")
public class SubjectCommentController {
    private final CrudService<SubjectCommentEntity> subjectCrudService;
    private final UserActionService<SubjectCommentEntity> userActionService;


    @GetMapping("/{id}")
    public SubjectCommentEntity findByIdJoinTeacher(@PathVariable long id) {
        return subjectCrudService.findById(id);
    }

    @PostMapping("/filter")
    public Page<SubjectCommentEntity> findAll(@RequestParam int page, @RequestParam int limit) {
        return null;
    }

    @PostMapping
    public SubjectCommentEntity create(@RequestBody SubjectCommentEntity entity) {
        return userActionService.create(entity);
    }

    @PutMapping("/{id}")
    public SubjectCommentEntity update(@RequestBody SubjectCommentEntity entity, @PathVariable long id) {
        return userActionService.update(entity, id);
    }

    @DeleteMapping("/{id}")
    public SubjectCommentEntity delete(@PathVariable long id) {
        return subjectCrudService.delete(id);
    }
}
