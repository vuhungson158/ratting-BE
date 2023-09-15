package kiis.ratingBE.common;

import kiis.ratingBE.features.subject.base.SubjectEntity;
import kiis.ratingBE.features.teacher.base.TeacherEntity;
import org.jetbrains.annotations.NotNull;

public abstract class Transferor {

    /**
     * @see TeacherEntity#joinSubjects
     * @see TeacherEntity#subjects
     */
    public static void subjects(@NotNull TeacherEntity teacherEntity) {
        teacherEntity.subjects = teacherEntity.joinSubjects
                .stream()
                .peek(subjectEntity -> subjectEntity.teacher = null)
                .toList();
    }

    /**
     * @see SubjectEntity#teacher
     * @see SubjectEntity#joinTeacher
     */
    public static void teacher(@NotNull SubjectEntity subjectEntity) {
        subjectEntity.teacher = subjectEntity.joinTeacher;
    }
}
