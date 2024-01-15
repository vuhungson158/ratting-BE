package kiis.ratingBE.service.teacher;

import kiis.ratingBE.model.teacher.TeacherEntity;
import kiis.ratingBE.repository.teacher.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TeacherMainService {
    private final TeacherRepository teacherRepository;

    public List<TeacherEntity> findAll() {
        return teacherRepository.findAllByIsDeletedIsFalse();
    }
}
