package kiis.ratingBE;

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
