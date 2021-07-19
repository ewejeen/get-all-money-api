package kr.kim.gam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GamApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamApplication.class, args);
	}

}
