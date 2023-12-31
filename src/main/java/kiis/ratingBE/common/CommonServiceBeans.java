package kiis.ratingBE.common;

import kiis.ratingBE.common.comment.CommentReactRepository;
import kiis.ratingBE.common.comment.CommentRepository;
import kiis.ratingBE.common.comment.CommentService;
import kiis.ratingBE.common.crud.CrudService;
import kiis.ratingBE.common.join.JoinService;
import kiis.ratingBE.common.userAction.UserActionService;
import kiis.ratingBE.features.auth.AuthService;
import kiis.ratingBE.features.subject.base.SubjectEntity;
import kiis.ratingBE.features.subject.base.SubjectJoinField;
import kiis.ratingBE.features.subject.comment.SubjectCommentEntity;
import kiis.ratingBE.features.subject.comment.SubjectCommentReactEntity;
import kiis.ratingBE.features.subject.rating.SubjectRatingEntity;
import kiis.ratingBE.features.teacher.base.TeacherEntity;
import kiis.ratingBE.features.teacher.base.TeacherJoinField;
import kiis.ratingBE.features.teacher.comment.TeacherCommentEntity;
import kiis.ratingBE.features.teacher.comment.TeacherCommentReactEntity;
import kiis.ratingBE.features.teacher.rating.TeacherRatingEntity;
import kiis.ratingBE.features.user.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class CommonServiceBeans {
    @Bean
    public CrudService<SubjectEntity> subjectCrudService(
            CommonRepository<SubjectEntity> subjectRepository) {
        return new CrudService<>(subjectRepository) {
        };
    }

    @Bean
    public JoinService<SubjectEntity, SubjectJoinField> subjectJoinService(
            CommonRepository<SubjectEntity> subjectRepository) {
        return new JoinService<>(subjectRepository) {
        };
    }

    @Bean
    public CrudService<SubjectCommentEntity> subjectCommentCrudService(
            CommonRepository<SubjectCommentEntity> subjectCommentCrudRepository) {
        return new CrudService<>(subjectCommentCrudRepository) {
        };
    }

    @Bean
    public UserActionService<SubjectCommentEntity> subjectCommentUserActionService(
            CrudService<SubjectCommentEntity> subjectCommentUserActionRepository,
            AuthService authService) {
        return new UserActionService<>(subjectCommentUserActionRepository, authService) {
        };
    }

    @Bean
    public CrudService<TeacherCommentEntity> teacherCommentCrudService(
            CommonRepository<TeacherCommentEntity> teacherCommentCrudRepository) {
        return new CrudService<>(teacherCommentCrudRepository) {
        };
    }

    @Bean
    public UserActionService<TeacherCommentEntity> teacherCommentUserActionService(
            CrudService<TeacherCommentEntity> teacherCommentUserActionRepository,
            AuthService authService) {
        return new UserActionService<>(teacherCommentUserActionRepository, authService) {
        };
    }

    @Bean
    public CrudService<SubjectRatingEntity> subjectRatingCrudService(
            CommonRepository<SubjectRatingEntity> subjectRatingCrudRepository) {
        return new CrudService<>(subjectRatingCrudRepository) {
        };
    }

    @Bean
    public UserActionService<SubjectRatingEntity> subjectRatingUserActionService(
            CrudService<SubjectRatingEntity> subjectRatingUserActionRepository,
            AuthService authService) {
        return new UserActionService<>(subjectRatingUserActionRepository, authService) {
        };
    }

    @Bean
    public CrudService<TeacherRatingEntity> teacherRatingCrudService(
            CommonRepository<TeacherRatingEntity> teacherRatingCrudRepository) {
        return new CrudService<>(teacherRatingCrudRepository) {
        };
    }

    @Bean
    public UserActionService<TeacherRatingEntity> teacherRatingUserActionService(
            CrudService<TeacherRatingEntity> teacherRatingUserActionRepository,
            AuthService authService) {
        return new UserActionService<>(teacherRatingUserActionRepository, authService) {
        };
    }

    @Bean
    public CommentService<SubjectCommentEntity, SubjectCommentReactEntity> subjectCommentService(
            CommentRepository<SubjectCommentEntity> subjectCommentRepository,
            CommentReactRepository<SubjectCommentReactEntity> subjectCommentReactRepository,
            AuthService authService) {
        return new CommentService<>(subjectCommentRepository, subjectCommentReactRepository, authService) {
            @Override
            protected SubjectCommentReactEntity newEmptyEntity() {
                return new SubjectCommentReactEntity();
            }
        };
    }

    @Bean
    public CommentService<TeacherCommentEntity, TeacherCommentReactEntity> teacherCommentService(
            CommentRepository<TeacherCommentEntity> teacherCommentRepository,
            CommentReactRepository<TeacherCommentReactEntity> teacherCommentReactRepository,
            AuthService authService) {
        return new CommentService<>(teacherCommentRepository, teacherCommentReactRepository, authService) {
            @Override
            protected TeacherCommentReactEntity newEmptyEntity() {
                return new TeacherCommentReactEntity();
            }
        };
    }

    @Bean
    public CrudService<TeacherEntity> teacherCrudService(
            CommonRepository<TeacherEntity> teacherRepository) {
        return new CrudService<>(teacherRepository) {
        };
    }

    @Bean
    public JoinService<TeacherEntity, TeacherJoinField> teacherJoinService(
            CommonRepository<TeacherEntity> teacherRepository) {
        return new JoinService<>(teacherRepository) {
        };
    }

    @Bean
    public CrudService<UserEntity> userCrudService(
            CommonRepository<UserEntity> userRepository) {
        return new CrudService<>(userRepository) {
        };
    }
}
