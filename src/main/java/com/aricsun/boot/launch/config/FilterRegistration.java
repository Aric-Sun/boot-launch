package com.aricsun.boot.launch.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 这个过滤器的注册方法要记住，因为可以在一个配置类里配置多个过滤器，统一设置执行顺序
 * @author AricSun
 * @date 2020.12.24 14:17
 */
@Configuration
public class FilterRegistration {

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        // Filter可以new，也可以使用依赖注入Bean
        registration.setFilter(new CustomFilter());
        // 设置名称
        registration.setName("customFilter");
        // 设置过滤路径
        registration.addUrlPatterns("/*");
        // 设置执行顺序
        registration.setOrder(10);  // 数字越小，优先级越高

        return registration;
    }
}
