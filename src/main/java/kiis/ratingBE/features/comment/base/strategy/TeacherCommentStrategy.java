package kiis.ratingBE.features.comment.base.strategy;

import kiis.ratingBE.features.comment.base.CommentProjector;
import kiis.ratingBE.features.comment.base.CommentRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static kiis.ratingBE.features.comment.base.strategy.CommentStategyEnum.TEACHER;

@Component
class TeacherCommentStrategy
        implements CommentStrategy {
    private final CommentRepository commentRepository;

    @Autowired
    public TeacherCommentStrategy(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public boolean useCase(@NotNull CommentStategyEnum strategy) {
        return TEACHER.equals(strategy);
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
