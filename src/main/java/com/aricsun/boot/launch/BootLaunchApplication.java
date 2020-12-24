package com.aricsun.boot.launch;

import com.aricsun.boot.launch.config.event.MyListener1;
import com.aricsun.boot.launch.model.LombokPOJO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = {"classpath:otherconfig/beans.xml"})
@MapperScan(basePackages = {"com.aricsun.boot.launch.mapper"})
@ServletComponentScan  // （ServletListener）：WebListener也是组件的一种,WebFilter同样
public class BootLaunchApplication {

	public static void main(String[] args) {

		// @Builder的效果
		LombokPOJO lombokPOJO = LombokPOJO.builder()
				.name("ariSun")
				.age(23)
				.build();

		// 第一种注册自定义事件监听器的方法
		ConfigurableApplicationContext context =
			SpringApplication.run(BootLaunchApplication.class, args);
		context.addApplicationListener(new MyListener1());
	}

}
