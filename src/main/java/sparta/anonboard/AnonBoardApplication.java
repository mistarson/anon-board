package sparta.anonboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AnonBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnonBoardApplication.class, args);
	}

}
