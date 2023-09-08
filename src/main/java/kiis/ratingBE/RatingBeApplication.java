package kiis.ratingBE;

import kiis.ratingBE.features.teacher.base.TeacherEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("kiis.ratingBE.features")
public class RatingBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(RatingBeApplication.class, args);
    }

}


//@Getter
//@Setter
//public class SubjectEntity {
//	private Integer id;
//	private String teacherName;
//	// Some other fields
//}
//
//public class Test{
//	public void test(TeacherEntity teacher){
//		final SubjectEntity subject = new SubjectEntity();
//		subject.setTeacherName(teacher.getName());
//		System.out.println(subject.getTeacherName());
//	}
//}

public class SubjectEntity {
    public Integer id;
    public String teacherName;
    // Some other fields
}

public class Test {
    public void test(TeacherEntity teacher) {
        final SubjectEntity subject = new SubjectEntity();
        subject.teacherName = teacher.name;
        System.out.println(subject.teacherName);
    }
}