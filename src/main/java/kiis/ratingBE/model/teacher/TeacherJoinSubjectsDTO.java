package kiis.ratingBE.model.teacher;

import kiis.ratingBE.helper.MappingUtil;
import kiis.ratingBE.model.common.DTO;
import kiis.ratingBE.model.subject.SubjectEntity;

import java.util.ArrayList;
import java.util.List;

public class TeacherJoinSubjectsDTO extends TeacherBaseModel implements DTO {
    public List<SubjectEntity> subjects = new ArrayList<>();

    public TeacherJoinSubjectsDTO(TeacherJoinEntity entity) {
        MappingUtil.copyProperties(entity, this, TeacherBaseModel.class);
        this.subjects = entity.subjects;
    }
}
