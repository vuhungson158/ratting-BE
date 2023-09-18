package kiis.ratingBE.features.subject.rating.model;

import kiis.ratingBE.common.BaseProjector;

@SuppressWarnings("unused")
public interface SubjectRatingAverageProjector
        extends BaseProjector {

    /**
     * @see SubjectRatingAverage#totalRecord
     */
    Long getTotalRecord();

    /**
     * @see SubjectRatingAverage#practicalityAverage
     */
    Double getPracticalityAverage();

    /**
     * @see SubjectRatingAverage#easyToUnderstandAverage
     */
    Double getEasyToUnderstandAverage();

    /**
     * @see SubjectRatingAverage#starAverage
     */
    Double getStarAverage();
}
