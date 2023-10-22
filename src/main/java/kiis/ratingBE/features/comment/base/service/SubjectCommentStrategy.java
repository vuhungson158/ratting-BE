package kiis.ratingBE.features.comment.base.service;

import kiis.ratingBE.features.comment.base.CommentProjector;
import kiis.ratingBE.features.comment.base.CommentRepository;
import org.springframework.stereotype.Component;

import java.util.List;

import static kiis.ratingBE.features.comment.base.service.CommentServiceImplementation.SUBJECT;

@Component
public class SubjectCommentStrategy
        implements CommentStrategy {
    private final CommentRepository commentRepository;

    public SubjectCommentStrategy(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public boolean useCase(CommentServiceImplementation implementation) {
        return SUBJECT.equals(implementation);
    }

    @Override
    public List<CommentProjector> findList(long id, int page, int limit) {
        return commentRepository.findPageBySubject(id, page, limit);
    }

    @Override
    public long count(long id) {
        return commentRepository.countBySubject(id);
    }
}
