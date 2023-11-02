package kiis.ratingBE.features.comment.base.strategy;

import kiis.ratingBE.exception.UnimplementedException;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentStrategyFactory {
    private final List<CommentStrategy> commentStrategies;

    @Autowired
    public CommentStrategyFactory(List<CommentStrategy> commentStrategies) {
        this.commentStrategies = commentStrategies;
    }

    /**
     * @param strategy name of strategy
     * @return CommentService's strategy
     */
    public @NotNull CommentStrategy getCommentStrategy(@NotNull CommentStategyEnum strategy) {
        for (final CommentStrategy commentStrategy : commentStrategies) {
            if (commentStrategy.useCase(strategy)) return commentStrategy;
        }
        throw new UnimplementedException();
    }
}
