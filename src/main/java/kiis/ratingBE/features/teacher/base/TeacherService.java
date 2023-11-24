package kiis.ratingBE.features.teacher.base;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public List<TeacherEntity> findAll() {
        return teacherRepository.findAllByIsDeletedIsFalse();
    }
}
