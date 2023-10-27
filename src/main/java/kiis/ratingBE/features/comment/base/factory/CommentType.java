package kiis.ratingBE.features.comment.base.factory;

import kiis.ratingBE.features.comment.base.CommentProjector;

import java.util.List;

public interface CommentFactory {

    boolean useCase(CommentFactoryImplementation implementation);

    List<CommentProjector> findList(long id, int page, int limit);

    long count(long id);
}
