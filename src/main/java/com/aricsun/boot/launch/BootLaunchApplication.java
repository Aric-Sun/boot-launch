package com.aricsun.boot.launch;

import com.aricsun.boot.launch.model.LombokPOJO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = {"classpath:beans.xml"})
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
