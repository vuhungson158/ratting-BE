package kiis.ratingBE.features.teacher.rating.dao;

import kiis.ratingBE.common.BaseProjector;

@SuppressWarnings("unused")
public interface TeacherRatingAverageProjector
        extends BaseProjector {

    /**
     * @see TeacherRatingAverage#totalRecord
     */
    Long getTotalRecord();

    /**
     * @see TeacherRatingAverage#enthusiasmAverage
     */
    Double getEnthusiasmAverage();

    /**
     * @see TeacherRatingAverage#friendlyAverage
     */
    Double getFriendlyAverage();

    /**
     * @see TeacherRatingAverage#enthusiasmAverage
     */
    Double getEruditionAverage();

    /**
     * @see TeacherRatingAverage#pedagogicalAverage
     */
    Double getPedagogicalAverage();

    /**
     * @see TeacherRatingAverage#starAverage
     */
    Double getStarAverage();
}
