package kiis.ratingBE.features.comment.base;

import kiis.ratingBE.common.crud.CrudController;
import kiis.ratingBE.exception.UnimplementedException;
import kiis.ratingBE.features.comment.base.service.CommentCommonService;
import kiis.ratingBE.features.comment.base.service.CommentService;
import kiis.ratingBE.features.comment.base.service.CommentServiceImplementation;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(path = "/comment")
@RestController
public class CommentController
        extends CrudController<CommentEntity>
        implements CommentEndpoint {

    private final List<CommentService> commentServices;

    @Autowired
    public CommentController(CommentCommonService commentService,
                             List<CommentService> commentServices) {
        super(commentService);
        this.commentServices = commentServices;
    }

    @GetMapping("/of")
    public Page<CommentEntity> findPageBy(CommentServiceImplementation implementation, long id, int page, int limit) {
        final CommentService commentService = getCommentService(implementation);
        return commentService.findPage(id, page, limit);
    }

    /**
     * @param implementation name of implementation of CommentService
     * @return CommentService's implementation
     */
    private @NotNull CommentService getCommentService(@NotNull CommentServiceImplementation implementation) {
        for (final CommentService commentService : commentServices) {
            final boolean caseMatching = commentService.useCase(implementation);
            if (caseMatching) return commentService;
        }
        throw new UnimplementedException();
    }
}
