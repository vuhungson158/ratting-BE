//package kiis.ratingBE.features.teacher.base;
//
//import kiis.ratingBE.aop.AllowFeature;
//import kiis.ratingBE.common.join.JoinController;
//import kiis.ratingBE.common.join.JoinService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import static kiis.ratingBE.enums.UserRole.Feature.TEACHER;
//
//@AllowFeature(TEACHER)
//@RestController
//@RequestMapping(path = "/teacher-join")
//public class TeacherJoinController
//        extends JoinController<TeacherEntity, TeacherJoinField> {
//    @Autowired
//    public TeacherJoinController(JoinService<TeacherEntity, TeacherJoinField> joinService) {
//        super(joinService);
//    }
//}