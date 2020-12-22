package com.aricsun.boot.launch;

import com.aricsun.boot.launch.model.LombokPOJO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = {"classpath:beans.xml"})
@MapperScan(basePackages = {"com.aricsun.boot.launch.generator"})
public class BootLaunchApplication {

	public static void main(String[] args) {

		// @Builder的效果
		LombokPOJO lombokPOJO = LombokPOJO.builder()
				.name("aricSun")
				.age(23)
				.build();

		SpringApplication.run(BootLaunchApplication.class, args);
	}

}
