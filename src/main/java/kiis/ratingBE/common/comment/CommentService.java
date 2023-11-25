package kiis.ratingBE.common.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
public abstract class CommentService<
        CommentEntity extends CommentBaseEntity,
        ReactEntity extends ReactBaseEntity<CommentEntity>
        > {
    private final CommentRepository<CommentEntity> commentRepository;
    private final CommentReactRepository<ReactEntity> commentReactRepository;

    // TODO
    public boolean like(@PathVariable long commentId) {
        return commentReactRepository.findById(commentId).isPresent();
    }

    // TODO
    public boolean dislike(@PathVariable long commentId) {
        return commentReactRepository.findById(commentId).isPresent();
    }
}
