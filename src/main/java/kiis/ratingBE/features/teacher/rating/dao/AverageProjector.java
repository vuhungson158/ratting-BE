package kiis.ratingBE.features.teacher.rating.dao;

@SuppressWarnings("unused")
public interface AverageProjector {
    /**
     * @see TeacherRatingAverage#teacherId
     */
    Long getTeacherId();

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
