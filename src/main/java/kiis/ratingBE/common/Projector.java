package kiis.ratingBE.common;

import kiis.ratingBE.features.subject.base.SubjectProjector;
import kiis.ratingBE.features.teacher.base.TeacherProjector;
import kiis.ratingBE.helper.Util;

/**
 * use this interface as return type of complicate Query (what need virtual column)<br>
 * use {@link Projector#to(Class)} to receive Class you want<br>
 * example:
 * <pre>
 *     final SubjectEntity subjectEntity = projector.to(SubjectEntity.class);
 *     final SubjectDto subjectDto = projector.to(SubjectDto.class);
 * </pre>
 */
public interface Projector extends
        SubjectProjector,
        TeacherProjector {

    default <T> T to(Class<T> type) {
        return Util.mapping(this, type);
    }
}
