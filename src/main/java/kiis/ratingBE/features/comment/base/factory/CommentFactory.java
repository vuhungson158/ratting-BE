package kiis.ratingBE.features.comment.base.factory;

import kiis.ratingBE.exception.UnimplementedException;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentFactory {
    private final List<CommentType> commentTypes;

    public CommentFactory(List<CommentType> commentStrategies) {
        this.commentTypes = commentStrategies;
    }


    /**
     * @param implementation name of implementation of CommentService
     * @return CommentService's implementation
     */
    public @NotNull CommentType getCommentType(@NotNull CommentFactoryImplementation implementation) {
        for (final CommentType commentStrategy : commentTypes) {
            final boolean caseMatching = commentStrategy.useCase(implementation);
            if (caseMatching) return commentStrategy;
        }
        throw new UnimplementedException();
    }
}
