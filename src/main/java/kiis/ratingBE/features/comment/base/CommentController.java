package kiis.ratingBE.features.comment.base;

import kiis.ratingBE.common.crud.CrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/comment")
@RestController
public class CommentController
        extends CrudController<CommentEntity>
        implements CommentEndpoint {

    @Autowired
    public CommentController(CommentService commentService) {
        super(commentService);
    }
}
