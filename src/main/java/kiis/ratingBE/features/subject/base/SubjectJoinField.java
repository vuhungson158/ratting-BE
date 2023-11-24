package kiis.ratingBE.features.subject.base;

import kiis.ratingBE.common.join.JoinField;
import lombok.RequiredArgsConstructor;

import java.util.function.Consumer;

@RequiredArgsConstructor
public enum SubjectJoinField
        implements JoinField<SubjectEntity> {

    /**
     * @see SubjectEntity#joinTeacher
     */
    TEACHER("joinTeacher", subjectEntity -> subjectEntity.teacher = subjectEntity.joinTeacher);

    /**
     * Must be exactly property name
     *
     * @see jakarta.persistence.OneToMany
     * @see jakarta.persistence.ManyToOne
     */
    private final String fieldName;

    /**
     * Should create a transfer method, and use lambda
     */
    private final Consumer<SubjectEntity> transferCallback;

    @Override
    public String fieldName() {
        return fieldName;
    }

    @Override
    public Consumer<SubjectEntity> transferCallback() {
        return transferCallback;
    }
}
