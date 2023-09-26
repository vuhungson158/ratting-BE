package kiis.ratingBE.features.comment.base.service;

import kiis.ratingBE.features.comment.base.CommentEntity;
import kiis.ratingBE.features.comment.base.CommentProjector;
import kiis.ratingBE.features.comment.base.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@RequiredArgsConstructor
public class CommentServiceBase {
    protected final CommentRepository commentRepository;

    protected Page<CommentEntity> createPageImpl(int page, int limit, long total,
                                                 @NotNull List<CommentProjector> queryResult) {
        final PageRequest pageRequest = PageRequest.of(page, limit);
        final List<CommentEntity> commentEntities = queryResult
                .stream()
                .map(projector -> projector.to(CommentEntity.class))
                .toList();
        return new PageImpl<>(commentEntities, pageRequest, total);
    }
}
