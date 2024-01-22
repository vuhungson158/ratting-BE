package kiis.ratingBE.controller;

import kiis.ratingBE.helper.MappingUtil;
import kiis.ratingBE.model.subject.SubjectEntity;
import kiis.ratingBE.model.subject.SubjectJoinEntity;
import kiis.ratingBE.model.subject.SubjectJoinTeacherDTO;
import kiis.ratingBE.model.subject.SubjectListFilter;
import kiis.ratingBE.service.common.CrudService;
import kiis.ratingBE.service.common.JoinService;
import kiis.ratingBE.service.subject.SubjectMainService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static kiis.ratingBE.enums.foreignKey.SubjectForeignKey.TEACHER;
import static kiis.ratingBE.service.common.JoinServiceTemplate.joins;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/subject")
public class SubjectController {
    private final SubjectMainService subjectMainService;
    private final CrudService<SubjectEntity> subjectCrudService;
    private final JoinService<SubjectJoinEntity> subjectJoinTeacherService;

    @GetMapping("/{id}")
    public SubjectJoinEntity findById(@PathVariable long id) {
        return subjectJoinTeacherService.findById(id, joins(TEACHER));
    }

    @PostMapping("/filter")
    public Page<SubjectJoinTeacherDTO> findAll(
            @RequestBody SubjectListFilter subjectListFilter,
            @RequestParam int page,
            @RequestParam int limit
    ) {
        final Specification<SubjectJoinEntity> filter = subjectMainService.getSpecification(subjectListFilter);
        final Pageable pagingAndSort = subjectMainService.getPagingAndSort(page, limit);
        final Page<SubjectJoinEntity> subjects = subjectJoinTeacherService.findAll(filter, pagingAndSort, joins(TEACHER));
        return MappingUtil.mappingPage(subjects, SubjectJoinTeacherDTO::new);
    }

    @PostMapping
    public void create(@RequestBody SubjectEntity entity) {
        subjectCrudService.create(entity);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody SubjectEntity entity, @PathVariable long id) {
        subjectCrudService.update(entity, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        subjectCrudService.delete(id);
    }
}
