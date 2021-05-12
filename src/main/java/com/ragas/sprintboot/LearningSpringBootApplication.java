package com.ragas.sprintboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearningSpringBootApplication {

//	public static void main(String[] args) {
//		SpringApplication.run(LearningSpringBootApplication.class, args);
//	}

	//Programmatically changing the banner
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(LearningSpringBootApplication.class);
		application.setBanner(new CustomBanner());
		application.run(args);
	}

}
