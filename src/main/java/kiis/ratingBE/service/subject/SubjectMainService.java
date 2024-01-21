package kiis.ratingBE.service.subject;

import kiis.ratingBE.model.subject.SubjectJoinEntity;
import kiis.ratingBE.model.subject.SubjectListFilter;
import kiis.ratingBE.service.common.SpecificationUtil;
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
    public Specification<SubjectJoinEntity> getSpecification(@NotNull SubjectListFilter filter) {
        return Specification
                .where(column("credit").between(filter.credit.from, filter.credit.to))
                .and(column("registrableYear").between(filter.registrableYear.from, filter.registrableYear.to))
                .and(column("name").include(filter.name))
                .and(column("department").is(filter.department))
                .and(column("classification").is(filter.classification))
                .and(column("require").is(filter.require))
                .and(column("isDeleted").is(false));
    }

    @Contract("_ -> new")
    private @NotNull SpecificationUtil<SubjectJoinEntity> column(String column) {
        return new SpecificationUtil<>(column) {
        };
    }

    public Pageable getPagingAndSort(int page, int limit) {
        return PageRequest.of(page, limit);
    }
}
