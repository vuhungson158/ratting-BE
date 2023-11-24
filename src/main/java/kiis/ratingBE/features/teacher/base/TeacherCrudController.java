//package kiis.ratingBE.features.teacher.base;
//
//import kiis.ratingBE.aop.AllowFeature;
//import kiis.ratingBE.common.crud.CrudController;
//import kiis.ratingBE.common.crud.CrudService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import static kiis.ratingBE.enums.UserRole.Feature.TEACHER;
//
//@AllowFeature(TEACHER)
//@RestController
//@RequestMapping(path = "/teacher-crud")
//public class TeacherCrudController
//        extends CrudController<TeacherEntity> {
//    @Autowired
//    public TeacherCrudController(CrudService<TeacherEntity> crudService) {
//        super(crudService);
//    }
//}
