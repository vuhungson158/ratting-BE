package kiis.ratingBE.features.teacher.base;

import kiis.ratingBE.common.join.JoinField;
import lombok.RequiredArgsConstructor;

import java.util.function.Consumer;

@RequiredArgsConstructor
public enum TeacherJoinField implements JoinField<TeacherEntity> {

    SUBJECTS("subject", TeacherEntity::transferSubjects),

    COMMENTS("comments", teacher -> {
        System.out.println("comments");
    });

    private final String fieldName;

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
