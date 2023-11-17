package kiis.ratingBE.features.rating;

import kiis.ratingBE.common.BaseEntity;
import kiis.ratingBE.common.CommonRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface RatingRepository<T extends BaseEntity, A extends Average>
        extends CommonRepository<T> {

}
