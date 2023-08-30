package kiis.ratingBE.features.subject.base;

import kiis.ratingBE.common.SimpleCurdService;
import kiis.ratingBE.exception.RecordNotFoundException;
import kiis.ratingBE.features.teacher.base.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService extends SimpleCurdService<SubjectEntity> {

    private final SubjectRepository subjectRepository;
    private final TeacherRepository teacherRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository,
                          TeacherRepository teacherRepository) {
        super(subjectRepository);
        this.subjectRepository = subjectRepository;
        this.teacherRepository = teacherRepository;
    }

    public List<SubjectEntity> findAll() {
        return subjectRepository.findAllByIsDeletedIsFalse();
    }

    @Override
    public SubjectEntity create(SubjectEntity entity) {
        final SubjectEntity returnEntity = super.create(entity);
        returnEntity.teacher = teacherRepository
                .findById(returnEntity.teacherId)
                .orElseThrow(() -> new RecordNotFoundException("Teacher", returnEntity.teacherId));
        return returnEntity;
    }

//    @Override
//    public Page<SubjectEntity> findAll(int page, int limit) {
//        final Pageable pageable = PageRequest.of(page, limit);
//        return subjectRepository.findAllByIsDeletedIsFalse(pageable);
//    }


//    @Override
//    public Page<SubjectEntity> findAll(SubjectEntity exampleEntity, int page, int limit) {
//        final Pageable pageable = PageRequest.of(page, limit);
//        final Example<SubjectEntity> example = Example.of(exampleEntity);
//        return subjectRepository.findAllByIsDeletedIsFalse(example, pageable);
//    }
}
