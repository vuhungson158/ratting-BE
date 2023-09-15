package kiis.ratingBE.common;

import kiis.ratingBE.features.comment.base.CommentProjector;
import kiis.ratingBE.features.comment.react.ReactProjector;
import kiis.ratingBE.features.subject.base.SubjectProjector;
import kiis.ratingBE.features.subject.rating.SubjectRatingProjector;
import kiis.ratingBE.features.teacher.base.TeacherProjector;
import kiis.ratingBE.features.teacher.rating.dao.TeacherRatingProjector;
import kiis.ratingBE.helper.Util;

/**
 * use this interface as a return type of complicated Query (what need virtual column)<br>
 * use {@link Projector#to(Class)} to receive Class you want<br>
 * example:
 * <pre>
 *     final SubjectEntity subjectEntity = projector.to(SubjectEntity.class);
 *     final SubjectDto subjectDto = projector.to(SubjectDto.class);
 * </pre>
 */
public interface Projector extends
        SubjectProjector, SubjectRatingProjector,
        TeacherProjector, TeacherRatingProjector,
        CommentProjector, ReactProjector {

    default <T> T to(Class<T> type) {
        return Util.mapping(this, type);
    }
}
