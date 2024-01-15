package kiis.ratingBE.features.subject.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/subject-comment")
public class SubjectCommentController {
//    private final CrudService<SubjectCommentEntity> subjectCommentCrudService;
//    private final UserActionService<SubjectCommentEntity> subjectCommentUserActionService;
//    private final CommentService<SubjectCommentEntity, SubjectCommentReactEntity> subjectCommentService;

//    @GetMapping("/react")
//    public void react(@RequestParam long commentId, @RequestParam ReactType reactType) {
//        subjectCommentService.react(commentId, reactType);
//    }
//
//    @GetMapping("/{id}")
//    public SubjectCommentEntity findById(@PathVariable long id) {
//        return subjectCommentCrudService.findById(id);
//    }
//
//    @GetMapping
//    public Page<SubjectCommentEntity> findPage(@RequestParam long subjectId, @RequestParam int page, @RequestParam int limit) {
//        return subjectCommentService.findPage(subjectId, page, limit);
//    }
//
//    @PostMapping
//    public SubjectCommentEntity create(@RequestBody SubjectCommentEntity entity) {
//        return subjectCommentUserActionService.create(entity);
//    }
//
//    @PutMapping("/{id}")
//    public SubjectCommentEntity update(@RequestBody SubjectCommentEntity entity, @PathVariable long id) {
//        return subjectCommentUserActionService.update(entity, id);
//    }
//
//    @DeleteMapping("/{id}")
//    public SubjectCommentEntity delete(@PathVariable long id) {
//        return subjectCommentCrudService.delete(id);
//    }
}
