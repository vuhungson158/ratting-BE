package kiis.ratingBE.features.teacher.base;

import kiis.ratingBE.common.join.JoinField;
import lombok.RequiredArgsConstructor;

import java.util.function.Consumer;

@RequiredArgsConstructor
public enum TeacherJoinField implements JoinField<TeacherEntity> {

    /**
     * @see TeacherEntity#subjectList
     */
    SUBJECTS("subjectList", TeacherEntity::transferSubjects);

    /**
     * Must be exactly property name
     *
     * @see jakarta.persistence.OneToMany
     * @see jakarta.persistence.ManyToOne
     */
    private final String fieldName;

    /**
     * Should create a transfer method in Entity, and use lambda
     */
    private final Consumer<TeacherEntity> transferCallback;

    @Override
    public String fieldName() {
        return fieldName;
    }

    @Override
    public Consumer<TeacherEntity> transferCallback() {
        return transferCallback;
    }
}
