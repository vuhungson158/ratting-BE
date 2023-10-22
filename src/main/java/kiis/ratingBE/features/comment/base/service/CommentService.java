package kiis.ratingBE.features.comment.base.service;

import kiis.ratingBE.common.crud.CrudService;
import kiis.ratingBE.exception.UnimplementedException;
import kiis.ratingBE.features.comment.base.CommentEndpoint;
import kiis.ratingBE.features.comment.base.CommentEntity;
import kiis.ratingBE.features.comment.base.CommentProjector;
import kiis.ratingBE.features.comment.base.CommentRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CommentService
        extends CrudService<CommentEntity>
        implements CommentEndpoint {
    private final CommentRepository commentRepository;
    private final List<CommentStrategy> commentStrategies;

    @Autowired
    public CommentService(CommentRepository commentRepository, List<CommentStrategy> commentStrategies) {
        super(commentRepository);
        this.commentRepository = commentRepository;
        this.commentStrategies = commentStrategies;
    }

    // TODO
    public boolean like(@PathVariable long id) {
        return true;
    }

    // TODO
    public boolean dislike(@PathVariable long id) {
        return true;
    }

    public Page<CommentEntity> findPageBy(CommentServiceImplementation implementation, long id, int page, int limit) {
        final CommentStrategy commentStrategy = getCommentStrategy(implementation);
        final List<CommentProjector> queryResult = commentStrategy.findList(id, page, limit);
        final long total = commentStrategy.count(id);
        return createPageImpl(page, limit, total, queryResult);
    }

    private @NotNull Page<CommentEntity> createPageImpl(int page, int limit, long total,
                                                        @NotNull List<CommentProjector> queryResult) {
        final PageRequest pageRequest = PageRequest.of(page, limit);
        final List<CommentEntity> commentEntities = queryResult
                .stream()
                .map(projector -> projector.to(CommentEntity.class))
                .toList();
        return new PageImpl<>(commentEntities, pageRequest, total);
    }

    /**
     * @param implementation name of implementation of CommentService
     * @return CommentService's implementation
     */
    private @NotNull CommentStrategy getCommentStrategy(@NotNull CommentServiceImplementation implementation) {
        for (final CommentStrategy commentStrategy : commentStrategies) {
            final boolean caseMatching = commentStrategy.useCase(implementation);
            if (caseMatching) return commentStrategy;
        }
        throw new UnimplementedException();
    }
}
