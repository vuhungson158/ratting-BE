package kiis.ratingBE.common.rating;

import kiis.ratingBE.common.CommonRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface RatingRepository
        extends CommonRepository<RatingEntity> {

}
