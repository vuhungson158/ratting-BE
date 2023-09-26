package kiis.ratingBE.features.comment.base.service;

import kiis.ratingBE.features.comment.base.CommentEntity;
import kiis.ratingBE.features.comment.base.CommentProjector;
import kiis.ratingBE.features.comment.base.CommentRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

import static kiis.ratingBE.features.comment.base.service.CommentServiceImplementation.SUBJECT;

@Service
public class SubjectCommentService
        extends CommentServiceBase
        implements CommentService {

    public SubjectCommentService(CommentRepository commentRepository) {
        super(commentRepository);
    }

    @Override
    public boolean useCase(CommentServiceImplementation implementation) {
        return SUBJECT.equals(implementation);
    }

    @Override
    public Page<CommentEntity> findPage(long id, int page, int limit) {
        final List<CommentProjector> queryResult = commentRepository.findPageBySubject(id, page, limit);
        final long total = commentRepository.countBySubject(id);
        return createPageImpl(page, limit, total, queryResult);
    }
}
