package kiis.ratingBE.service.subject;

import kiis.ratingBE.model.subject.SubjectEntity;
import kiis.ratingBE.repository.common.CommonRepository;
import kiis.ratingBE.service.common.CrudService;
import kiis.ratingBE.service.common.CrudServiceTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubjectCrudService
        extends CrudServiceTemplate<SubjectEntity>
        implements CrudService<SubjectEntity> {
    private final CommonRepository<SubjectEntity> subjectCrudRepository;

    @Override
    protected CommonRepository<SubjectEntity> getCrudRepository() {
        return subjectCrudRepository;
    }
}
