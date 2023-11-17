package kiis.ratingBE.features.rating;

import kiis.ratingBE.common.BaseEntity;
import kiis.ratingBE.common.crud.CrudController;
import kiis.ratingBE.common.crud.CrudService;
import kiis.ratingBE.features.subject.rating.SubjectRatingEndpoint;

public abstract class RatingController<T extends BaseEntity>
        extends CrudController<T>
        implements SubjectRatingEndpoint {
    public RatingController(CrudService<T> mainService) {
        super(mainService);
    }
}
