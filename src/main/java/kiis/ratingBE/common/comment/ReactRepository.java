package kiis.ratingBE.common.comment;

import kiis.ratingBE.common.CommonRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ReactRepository extends
        CommonRepository<ReactBaseEntity> {
}
