package kiis.ratingBE.service.subject;

import kiis.ratingBE.model.subject.SubjectJoinTeacherEntity;
import kiis.ratingBE.model.subject.SubjectListFilter;
import kiis.ratingBE.service.SpecificationUtil;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubjectMainService {
    public Specification<SubjectJoinTeacherEntity> getSpecification(@NotNull SubjectListFilter filter) {
        return Specification
                .where(column("credit").between(filter.creditFrom, filter.creditTo))
                .and(column("registrableYear").between(filter.registrableYearFrom, filter.registrableYearTo))
                .and(column("name").include(filter.name))
                .and(column("department").is(filter.department))
                .and(column("classification").is(filter.classification))
                .and(column("require").is(filter.require))
                .and(column("isDeleted").is(false));
    }

    @Contract("_ -> new")
    private @NotNull SpecificationUtil<SubjectJoinTeacherEntity> column(String column) {
        return new SpecificationUtil<>(column) {
        };
    }

    public Pageable getPaging(int page, int limit) {
        return PageRequest.of(page, limit);
    }
}
