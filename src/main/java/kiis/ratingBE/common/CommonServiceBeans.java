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
import kiis.ratingBE.features.teacher.base.TeacherEntity;
import kiis.ratingBE.features.teacher.base.TeacherJoinField;
import kiis.ratingBE.features.user.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class CommonServiceBeans {
    @Bean
    public CrudService<SubjectEntity> subjectCrudService(
            @Autowired CommonRepository<SubjectEntity> subjectRepository) {
        return new CrudService<>(subjectRepository) {
        };
    }

    @Bean
    public JoinService<SubjectEntity, SubjectJoinField> subjectJoinService(
            @Autowired CommonRepository<SubjectEntity> subjectRepository) {
        return new JoinService<>(subjectRepository) {
        };
    }

    @Bean
    public CrudService<SubjectCommentEntity> subjectCommentCrudService(
            @Autowired CommonRepository<SubjectCommentEntity> subjectCommentCrudRepository) {
        return new CrudService<>(subjectCommentCrudRepository) {
        };
    }

    @Bean
    public UserActionService<SubjectCommentEntity> subjectCommentUserActionService(
            @Autowired CrudService<SubjectCommentEntity> subjectCommentUserActionRepository,
            @Autowired AuthService authService) {
        return new UserActionService<>(subjectCommentUserActionRepository, authService) {
        };
    }

    @Bean
    public CommentService<SubjectCommentEntity, SubjectCommentReactEntity> subjectCommentService(
            @Autowired CommentRepository<SubjectCommentEntity> subjectCommentRepository,
            @Autowired CommentReactRepository<SubjectCommentReactEntity> subjectCommentReactRepository) {
        return new CommentService<>(subjectCommentRepository, subjectCommentReactRepository) {
        };
    }

    @Bean
    public CrudService<TeacherEntity> teacherCrudService(
            @Autowired CommonRepository<TeacherEntity> teacherRepository) {
        return new CrudService<>(teacherRepository) {
        };
    }

    @Bean
    public JoinService<TeacherEntity, TeacherJoinField> teacherJoinService(
            @Autowired CommonRepository<TeacherEntity> teacherRepository) {
        return new JoinService<>(teacherRepository) {
        };
    }

    @Bean
    public CrudService<UserEntity> userCrudService(
            @Autowired CommonRepository<UserEntity> userRepository) {
        return new CrudService<>(userRepository) {
        };
    }
}
