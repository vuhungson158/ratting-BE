package kiis.ratingBE.features.comment.base.service;

import kiis.ratingBE.features.comment.base.CommentEntity;
import kiis.ratingBE.features.comment.base.CommentProjector;
import kiis.ratingBE.features.comment.base.CommentRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

import static kiis.ratingBE.features.comment.base.service.CommentServiceImplementation.TEACHER;

@Service
public class TeacherCommentService
        extends CommentServiceBase
        implements CommentService {

    public TeacherCommentService(CommentRepository commentRepository) {
        super(commentRepository);
    }

    @Override
    public boolean useCase(@NotNull CommentServiceImplementation implementation) {
        return TEACHER.equals(implementation);
    }

    @Override
    public Page<CommentEntity> findPage(long id, int page, int limit) {
        final List<CommentProjector> queryResult = commentRepository.findPageByTeacher(id, page, limit);
        final long total = commentRepository.countByTeacher(id);
        return createPageImpl(page, limit, total, queryResult);
    }
}
