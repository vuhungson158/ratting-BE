package kiis.ratingBE.model.subject;

import kiis.ratingBE.helper.Util;
import kiis.ratingBE.model.common.DTO;
import kiis.ratingBE.model.teacher.TeacherEntity;

public class SubjectJoinTeacherDTO extends SubjectBaseModel implements DTO {
    public TeacherEntity teacher;

    public SubjectJoinTeacherDTO(SubjectJoinEntity subjectJoinEntity) {
        Util.copyProperties(subjectJoinEntity, this, SubjectBaseModel.class);
        this.teacher = subjectJoinEntity.teacher;
    }
}
