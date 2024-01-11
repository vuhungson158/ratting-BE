package kiis.ratingBE.service.subject;

import kiis.ratingBE.common.CommonRepository;
import kiis.ratingBE.common.crud.CrudService;
import kiis.ratingBE.model.subject.SubjectEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubjectCrudService extends CrudService<SubjectEntity> {
    private final CommonRepository<SubjectEntity> subjectCrudRepository;

    @Override
    protected CommonRepository<SubjectEntity> getCrudRepository() {
        return subjectCrudRepository;
    }
}
