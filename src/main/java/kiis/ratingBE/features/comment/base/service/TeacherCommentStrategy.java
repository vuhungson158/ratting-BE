package kiis.ratingBE.features.comment.base.service;

import kiis.ratingBE.features.comment.base.CommentProjector;
import kiis.ratingBE.features.comment.base.CommentRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.List;

import static kiis.ratingBE.features.comment.base.service.CommentServiceImplementation.TEACHER;

@Component
public class TeacherCommentStrategy
        implements CommentStrategy {
    private final CommentRepository commentRepository;

    public TeacherCommentStrategy(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public boolean useCase(@NotNull CommentServiceImplementation implementation) {
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
