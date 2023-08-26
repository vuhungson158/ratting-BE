package kiis.ratingBE.features.subject.base;

import kiis.ratingBE.common.SimpleCurdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService extends SimpleCurdService<SubjectEntity> {

    @Autowired
    public SubjectService(SubjectRepository repository) {
        super(repository);
    }
}
