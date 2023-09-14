package kiis.ratingBE.features.comment.base;

import kiis.ratingBE.common.Projector;
import kiis.ratingBE.common.SimpleCurdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService
        extends SimpleCurdService<CommentEntity>
        implements CommentEndpoint {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        super(commentRepository);
        this.commentRepository = commentRepository;
    }

    @Override
    public Page<CommentEntity> findAll(int page, int limit) {
        final List<Projector> queryResult = commentRepository.findAll(page, limit);
        final PageRequest pageRequest = PageRequest.of(page, limit);
        final long total = commentRepository.count();
        final List<CommentEntity> commentEntities = queryResult
                .stream()
                .map(projector -> projector.to(CommentEntity.class))
                .toList();
        return new PageImpl<>(commentEntities, pageRequest, total);
    }
}
