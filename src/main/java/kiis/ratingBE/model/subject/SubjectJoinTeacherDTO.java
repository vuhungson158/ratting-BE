package kiis.ratingBE.model.subject;

import kiis.ratingBE.helper.MappingUtil;
import kiis.ratingBE.model.common.DTO;
import kiis.ratingBE.model.teacher.TeacherEntity;

public class SubjectJoinTeacherDTO extends SubjectBaseModel implements DTO {
    public TeacherEntity teacher;

    public SubjectJoinTeacherDTO(SubjectJoinEntity subjectJoinEntity) {
        MappingUtil.copyProperties(subjectJoinEntity, this, SubjectBaseModel.class);
        this.teacher = subjectJoinEntity.teacher;
    }
}
