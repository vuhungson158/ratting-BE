package kiis.ratingBE.service.subject;

import kiis.ratingBE.model.subject.SubjectJoinTeacherEntity;
import kiis.ratingBE.repository.subject.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubjectMainService {
    private final SubjectRepository subjectRepository;

    public Specification<SubjectJoinTeacherEntity> getSpecification(SubjectJoinTeacherEntity exampleEntity) {
        return (root, query, criteriaBuilder) -> null;
    }

    public Pageable getPaging(int page, int limit) {
        return PageRequest.of(page, limit);
    }
}
