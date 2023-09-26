package kiis.ratingBE.features.comment.base.service;

import kiis.ratingBE.common.crud.CrudService;
import kiis.ratingBE.features.comment.base.CommentEndpoint;
import kiis.ratingBE.features.comment.base.CommentEntity;
import kiis.ratingBE.features.comment.base.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentCommonService
        extends CrudService<CommentEntity>
        implements CommentEndpoint {

    @Autowired
    public CommentCommonService(CommentRepository commentRepository) {
        super(commentRepository);
    }
}
