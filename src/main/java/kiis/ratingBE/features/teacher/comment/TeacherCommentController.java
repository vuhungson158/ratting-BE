package kiis.ratingBE.features.teacher.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/teacher-comment")
public class TeacherCommentController {
//    private final CrudServiceTemplate<TeacherCommentEntity> teacherCommentCrudService;
//    private final UserActionService<TeacherCommentEntity> teacherCommentUserActionService;
//    private final CommentService<TeacherCommentEntity, TeacherCommentReactEntity> teacherCommentService;

//    @GetMapping("/react")
//    public void react(@RequestParam long commentId, @RequestParam ReactType reactType) {
//        teacherCommentService.react(commentId, reactType);
//    }
//
//    @GetMapping("/{id}")
//    public TeacherCommentEntity findById(@PathVariable long id) {
//        return teacherCommentCrudService.findById(id);
//    }
//
//    @GetMapping
//    public Page<TeacherCommentEntity> findPage(@RequestParam long teacherId, @RequestParam int page, @RequestParam int limit) {
//        return teacherCommentService.findPage(teacherId, page, limit);
//    }
//
//    @PostMapping
//    public TeacherCommentEntity create(@RequestBody TeacherCommentEntity entity) {
//        return teacherCommentUserActionService.create(entity);
//    }
//
//    @PutMapping("/{id}")
//    public TeacherCommentEntity update(@RequestBody TeacherCommentEntity entity, @PathVariable long id) {
//        return teacherCommentUserActionService.update(entity, id);
//    }
//
//    @DeleteMapping("/{id}")
//    public TeacherCommentEntity delete(@PathVariable long id) {
//        return teacherCommentCrudService.delete(id);
//    }
}
