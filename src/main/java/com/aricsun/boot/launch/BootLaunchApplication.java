package com.aricsun.boot.launch;

import com.aricsun.boot.launch.model.LombokPOJO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootLaunchApplication {

	public static void main(String[] args) {

		// @BuilderµÄÐ§¹û
		LombokPOJO lombokPOJO = LombokPOJO.builder()
				.name("aricSun")
				.age(23)
				.build();

		SpringApplication.run(BootLaunchApplication.class, args);
	}

}
