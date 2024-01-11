package kiis.ratingBE.enums.foreignKey;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum TeacherForeignKey {
    SUBJECTS("subjects");

    public final String fieldName;
}
