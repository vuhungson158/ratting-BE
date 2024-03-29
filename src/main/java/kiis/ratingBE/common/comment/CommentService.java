package kiis.ratingBE.common.comment;

import kiis.ratingBE.enums.ReactType;
import kiis.ratingBE.service.user.AuthService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class CommentService<
        CommentEntity extends CommentBaseEntity,
        CommentReactEntity extends ReactBaseEntity<CommentEntity>
        > {
    private final CommentRepository<CommentEntity> commentRepository;
    private final CommentReactRepository<CommentReactEntity> commentReactRepository;
    private final AuthService authService;

    public void react(long commentId, ReactType reactType) {
        final Optional<CommentReactEntity> reactEntityOptional = findReactEntity(commentId);
        if (reactEntityOptional.isPresent()) {
            final CommentReactEntity reactEntity = reactEntityOptional.get();
            if (reactEntity.react.equals(reactType)) {
                commentReactRepository.delete(reactEntity);
            } else {
                reactEntity.react = reactType;
                commentReactRepository.save(reactEntity);
            }
        } else {
            commentReactRepository.save(newReactEntity(commentId, reactType));
        }
    }

    private @NotNull CommentReactEntity newReactEntity(long commentId, ReactType reactType) {
        final CommentReactEntity reactEntity = newEmptyEntity();
        reactEntity.commentId = commentId;
        reactEntity.react = reactType;
        reactEntity.userId = authService.getLongingUserId();
        return reactEntity;
    }

    protected abstract CommentReactEntity newEmptyEntity();

    private Optional<CommentReactEntity> findReactEntity(long commentId) {
        final Long longingUserId = authService.getLongingUserId();
        return commentReactRepository.findByCommentIdAndUserId(commentId, longingUserId);
    }

    public Page<CommentEntity> findPage(long parentId, int page, int limit) {
        final List<CommentEntity> commentEntitieList = commentRepository.findPageBy(parentId, page, limit);
        final long total = commentRepository.countBy(parentId);
        return new PageImpl<>(commentEntitieList, PageRequest.of(page, limit), total);
    }
}
