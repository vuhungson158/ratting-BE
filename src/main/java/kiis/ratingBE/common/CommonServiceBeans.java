package kiis.ratingBE.common;

import kiis.ratingBE.common.crud.CrudService;
import kiis.ratingBE.common.join.JoinService;
import kiis.ratingBE.features.subject.base.SubjectEntity;
import kiis.ratingBE.features.subject.base.SubjectJoinField;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class CommonServiceBeans {
    @Bean
    public CrudService<SubjectEntity> subjectCrudService(@Autowired CommonRepository<SubjectEntity> subjectRepository) {
        return new CrudService<>(subjectRepository) {
        };
    }

    @Bean
    public JoinService<SubjectEntity, SubjectJoinField> subjectJoinService(@Autowired CommonRepository<SubjectEntity> subjectRepository) {
        return new JoinService<>(subjectRepository) {
        };
    }
}
