package kiis.ratingBE.model.subject;

import kiis.ratingBE.helper.Util;
import kiis.ratingBE.model.teacher.TeacherEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

public class SubjectJoinTeacherDTO extends SubjectBaseModel {
    public TeacherEntity teacher;

    private SubjectJoinTeacherDTO() {
    }

    public SubjectJoinTeacherDTO(SubjectJoinEntity subjectJoinEntity) {
        this();
        Util.copyProperties(subjectJoinEntity, this);
        this.teacher = subjectJoinEntity.teacher;
    }

    public static @NotNull Page<SubjectJoinTeacherDTO> from(@NotNull Page<SubjectJoinEntity> subjectJoinEntities) {
        final List<SubjectJoinTeacherDTO> dtos = subjectJoinEntities.getContent().stream()
                .map(SubjectJoinTeacherDTO::new)
                .toList();
        return new PageImpl<>(dtos, subjectJoinEntities.getPageable(), subjectJoinEntities.getTotalElements());
    }
}
