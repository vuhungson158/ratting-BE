package kiis.ratingBE.service.teacher;

import kiis.ratingBE.model.teacher.TeacherEntity;
import kiis.ratingBE.repository.teacher.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TeacherMainService {
    private final TeacherRepository teacherRepository;

    public List<TeacherEntity> findAll() {
        final List<TeacherEntity> result = teacherRepository.findAllByIsDeletedIsFalse();
        result.sort(sortById());
        return result;
    }

    @Contract(pure = true)
    private @NotNull Comparator<TeacherEntity> sortById() {
        return (o1, o2) -> Math.toIntExact(o1.id - o2.id);
    }
}
