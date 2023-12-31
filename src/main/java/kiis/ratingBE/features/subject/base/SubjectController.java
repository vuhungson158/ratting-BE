package kiis.ratingBE.features.subject.base;

import kiis.ratingBE.common.crud.CrudService;
import kiis.ratingBE.common.join.JoinService;
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

import static kiis.ratingBE.features.subject.base.SubjectJoinField.TEACHER;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/subject")
public class SubjectController {
    private final CrudService<SubjectEntity> subjectCrudService;
    private final JoinService<SubjectEntity, SubjectJoinField> subjectJoinService;

    @GetMapping("/{id}")
    public SubjectEntity findByIdJoinTeacher(@PathVariable long id) {
        return subjectJoinService.findByIdJoin(id, TEACHER);
    }

    @PostMapping("/filter")
    public Page<SubjectEntity> findAll(@RequestBody SubjectEntity exampleEntity, @RequestParam int page, @RequestParam int limit) {
        return subjectCrudService.findAll(exampleEntity, page, limit);
    }

    @PostMapping
    public SubjectEntity create(@RequestBody SubjectEntity entity) {
        return subjectCrudService.create(entity);
    }

    @PutMapping("/{id}")
    public SubjectEntity update(@RequestBody SubjectEntity entity, @PathVariable long id) {
        return subjectCrudService.update(entity, id);
    }

    @DeleteMapping("/{id}")
    public SubjectEntity delete(@PathVariable long id) {
        return subjectCrudService.delete(id);
    }
}
