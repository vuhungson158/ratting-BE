package kiis.ratingBE.features.subject.rating;

import kiis.ratingBE.common.crud.CrudService;
import kiis.ratingBE.common.rating.RatingRepository;
import kiis.ratingBE.common.userAction.UserActionService;
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
@RequestMapping(path = "/subject-rating")
@RestController
public class SubjectRatingController {
//    private final CrudService<SubjectRatingEntity> subjectRatingCrudService;
//    private final UserActionService<SubjectRatingEntity> subjectRatingUserActionService;
//    private final RatingRepository<SubjectRatingEntity, SubjectRatingAverage> subjectRatingRepository;

//    @GetMapping("/findOne")
//    public SubjectRatingEntity findBySubjectIdAndUserId(long subjectId, long userId) {
//        return subjectRatingRepository.findByParentIdAndUserId(subjectId, userId);
//    }
//
//    @GetMapping("/subjectId/{subjectId}")
//    public SubjectRatingAverage findAverageBySubjectId(@PathVariable long subjectId) {
//        return subjectRatingRepository.findAverageByParentId(subjectId);
//    }
//
//    @GetMapping("/userId/{userId}")
//    public SubjectRatingAverage findAverageByUserId(@PathVariable long userId) {
//        return subjectRatingRepository.findAverageByUserId(userId);
//    }
//
//    @PostMapping
//    public SubjectRatingEntity create(@RequestBody SubjectRatingEntity entity) {
//        return subjectRatingUserActionService.create(entity);
//    }
//
//    @PutMapping("/{id}")
//    public SubjectRatingEntity update(@RequestBody SubjectRatingEntity entity, @PathVariable long id) {
//        return subjectRatingUserActionService.update(entity, id);
//    }
//
//    @DeleteMapping("/{id}")
//    public SubjectRatingEntity delete(@PathVariable long id) {
//        return subjectRatingCrudService.delete(id);
//    }
}
