package kiis.ratingBE.enums.foreignKey;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum SubjectForeignKey implements ForeignKey {
    TEACHER("teacher");

    private final String fieldName;

    @Override
    public String fieldName() {
        return fieldName;
    }
}
