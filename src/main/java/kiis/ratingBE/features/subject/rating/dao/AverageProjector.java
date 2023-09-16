package kiis.ratingBE.features.subject.rating.dao;

@SuppressWarnings("unused")
public interface AverageProjector {

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
