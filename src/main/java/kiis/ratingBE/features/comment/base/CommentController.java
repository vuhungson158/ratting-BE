package kiis.ratingBE.features.comment.base;

import kiis.ratingBE.common.crud.CrudController;
import kiis.ratingBE.features.comment.base.factory.CommentFactoryImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/comment")
@RestController
public class CommentController
        extends CrudController<CommentEntity>
        implements CommentEndpoint {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentCommonService) {
        super(commentCommonService);
        this.commentService = commentCommonService;
    }

    @GetMapping("/of")
    public Page<CommentEntity> findPageBy(CommentFactoryImplementation implementation, long id, int page, int limit) {
        return commentService.findPageBy(implementation, id, page, limit);
    }

    @GetMapping("/like/{id}")
    public boolean like(@PathVariable long id) {
        return commentService.like(id);
    }

    @GetMapping("/dislike/{id}")
    public boolean dislike(@PathVariable long id) {
        return commentService.dislike(id);
    }
}
