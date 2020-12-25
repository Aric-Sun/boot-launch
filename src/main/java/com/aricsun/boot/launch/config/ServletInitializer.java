package com.aricsun.boot.launch.config;

import com.aricsun.boot.launch.BootLaunchApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 使用外置tomcat
 * @author AricSun
 * @date 2020.12.25 2:06
 */
public class ServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 此处的Application.class为带有@SpringBootApplication注解的后动类
        return builder.sources(BootLaunchApplication.class);
    }
}
