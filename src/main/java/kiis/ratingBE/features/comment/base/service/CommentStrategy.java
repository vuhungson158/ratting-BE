package kiis.ratingBE.features.comment.base.service;

import kiis.ratingBE.features.comment.base.CommentProjector;

import java.util.List;

public interface CommentStrategy {

    boolean useCase(CommentServiceImplementation implementation);

    List<CommentProjector> findList(long id, int page, int limit);

    long count(long id);
}
