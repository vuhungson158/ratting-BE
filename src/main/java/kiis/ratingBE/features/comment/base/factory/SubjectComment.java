package kiis.ratingBE.features.comment.base.factory;

import kiis.ratingBE.features.comment.base.CommentProjector;
import kiis.ratingBE.features.comment.base.CommentRepository;
import org.springframework.stereotype.Component;

import java.util.List;

import static kiis.ratingBE.features.comment.base.factory.CommentFactoryImplementation.SUBJECT;

@Component
public class SubjectComment
        implements CommentType {
    private final CommentRepository commentRepository;

    public SubjectComment(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public boolean useCase(CommentFactoryImplementation implementation) {
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
