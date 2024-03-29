package kiis.ratingBE.controller;

import kiis.ratingBE.model.teacher.TeacherEntity;
import kiis.ratingBE.model.teacher.TeacherJoinEntity;
import kiis.ratingBE.model.teacher.TeacherJoinSubjectsDTO;
import kiis.ratingBE.service.common.CrudService;
import kiis.ratingBE.service.common.JoinService;
import kiis.ratingBE.service.teacher.TeacherMainService;
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

import static kiis.ratingBE.enums.foreignKey.TeacherForeignKey.SUBJECTS;
import static kiis.ratingBE.service.common.JoinServiceTemplate.joins;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/teacher")
public class TeacherController {
    private final CrudService<TeacherEntity> teacherCrudService;
    private final JoinService<TeacherJoinEntity> teacherJoinSubjectService;
    private final TeacherMainService teacherMainService;

    @GetMapping("/{id}")
    public TeacherJoinSubjectsDTO findByIdJoinSubject(@PathVariable long id) {
        final TeacherJoinEntity entity = teacherJoinSubjectService.findById(id, joins(SUBJECTS));
        return new TeacherJoinSubjectsDTO(entity);
    }

    @GetMapping
    public List<TeacherEntity> findAll() {
        return teacherMainService.findAll();
    }

    @PostMapping
    public Long create(@RequestBody TeacherEntity entity) {
        return teacherCrudService.create(entity).id;
    }

    @PutMapping("/{id}")
    public Long update(@RequestBody TeacherEntity entity, @PathVariable long id) {
        return teacherCrudService.update(entity, id).id;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        teacherCrudService.delete(id);
    }
}
