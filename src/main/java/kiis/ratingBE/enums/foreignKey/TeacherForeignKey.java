package kiis.ratingBE.enums.foreignKey;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum TeacherForeignKey implements ForeignKey {
    SUBJECTS("subjects");

    private final String fieldName;

    @Override
    public String fieldName() {
        return fieldName;
    }
}
