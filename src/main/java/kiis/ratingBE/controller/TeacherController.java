package kiis.ratingBE.controller;

import kiis.ratingBE.common.crud.CrudService;
import kiis.ratingBE.common.join.JoinService;
import kiis.ratingBE.model.teacher.TeacherEntity;
import kiis.ratingBE.model.teacher.TeacherJoinSubjectEntity;
import kiis.ratingBE.service.teacher.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/teacher")
public class TeacherController {
    private final CrudService<TeacherEntity> teacherCrudService;
    private final JoinService<TeacherJoinSubjectEntity> teacherJoinSubjectService;
    private final TeacherService teacherMainService;

    @GetMapping("/{id}")
    public TeacherJoinSubjectEntity findByIdJoinSubject(@PathVariable long id) {
        return teacherJoinSubjectService.findByIdJoin(id);
    }

    @GetMapping
    public List<TeacherEntity> findAll() {
        return teacherMainService.findAll();
    }

    @PostMapping
    public TeacherEntity create(@RequestBody TeacherEntity entity) {
        return teacherCrudService.create(entity);
    }

    @PutMapping("/{id}")
    public TeacherEntity update(@RequestBody TeacherEntity entity, @PathVariable long id) {
        return teacherCrudService.update(entity, id);
    }

    @DeleteMapping("/{id}")
    public TeacherEntity delete(@PathVariable long id) {
        return teacherCrudService.delete(id);
    }
}
