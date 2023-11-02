package kiis.ratingBE.features.comment.base;

import kiis.ratingBE.common.crud.CrudService;
import kiis.ratingBE.features.comment.base.strategy.CommentStrategyFactory;
import kiis.ratingBE.features.comment.base.strategy.CommentStrategy;
import kiis.ratingBE.features.comment.base.strategy.CommentStategyEnum;
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
    private final CommentStrategyFactory commentFactory;

    @Autowired
    public CommentService(CommentRepository commentRepository, CommentStrategyFactory commentFactory) {
        super(commentRepository);
        this.commentFactory = commentFactory;
    }

    // TODO
    public boolean like(@PathVariable long id) {
        return true;
    }

    // TODO
    public boolean dislike(@PathVariable long id) {
        return true;
    }

    public Page<CommentEntity> findPageBy(CommentStategyEnum implementation, long id, int page, int limit) {
        final CommentStrategy commentType = commentFactory.getCommentStrategy(implementation);
        final List<CommentProjector> queryResult = commentType.findList(id, page, limit);
        final long total = commentType.count(id);
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

}
