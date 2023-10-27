package kiis.ratingBE.features.comment.base.factory;

import kiis.ratingBE.features.comment.base.CommentProjector;
import kiis.ratingBE.features.comment.base.CommentRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.List;

import static kiis.ratingBE.features.comment.base.factory.CommentFactoryImplementation.TEACHER;

@Component
public class TeacherComment
        implements CommentType {
    private final CommentRepository commentRepository;

    public TeacherComment(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public boolean useCase(@NotNull CommentFactoryImplementation implementation) {
        return TEACHER.equals(implementation);
    }

    @Override
    public List<CommentProjector> findList(long id, int page, int limit) {
        return commentRepository.findPageByTeacher(id, page, limit);
    }

    @Override
    public long count(long id) {
        return commentRepository.countByTeacher(id);
    }
}
