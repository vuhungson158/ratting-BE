package kiis.ratingBE.features.subject.comment;

import kiis.ratingBE.common.comment.CommentService;
import kiis.ratingBE.common.crud.CrudService;
import kiis.ratingBE.common.userAction.UserActionService;
import kiis.ratingBE.enums.ReactType;
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
    private final CrudService<SubjectCommentEntity> subjectCommentCrudService;
    private final UserActionService<SubjectCommentEntity> subjectCommentUserActionService;
    private final CommentService<SubjectCommentEntity, SubjectCommentReactEntity> subjectCommentService;

    @GetMapping("/react")
    public void react(@RequestParam long commentId, @RequestParam ReactType reactType) {
        subjectCommentService.react(commentId, reactType);
    }

    @GetMapping("/{id}")
    public SubjectCommentEntity findById(@PathVariable long id) {
        return subjectCommentCrudService.findById(id);
    }

    @GetMapping
    public Page<SubjectCommentEntity> findPage(@RequestParam long subjectId, @RequestParam int page, @RequestParam int limit) {
        return subjectCommentService.findPage(subjectId, page, limit);
    }

    @PostMapping
    public SubjectCommentEntity create(@RequestBody SubjectCommentEntity entity) {
        return subjectCommentUserActionService.create(entity);
    }

    @PutMapping("/{id}")
    public SubjectCommentEntity update(@RequestBody SubjectCommentEntity entity, @PathVariable long id) {
        return subjectCommentUserActionService.update(entity, id);
    }

    @DeleteMapping("/{id}")
    public SubjectCommentEntity delete(@PathVariable long id) {
        return subjectCommentCrudService.delete(id);
    }
}
