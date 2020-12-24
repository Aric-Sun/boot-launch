package com.aricsun.boot.launch.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * Spring拦截器 的 配置类 ，用于注册
 * @author AricSun
 * @date 2020.12.24 14:55
 */
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Resource
    CustomHandlerInterceptor customHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器，拦截规则
        // 多个拦截器时，依次添加，，执行顺序按照添加顺序（只需使用下面一句，不需要创建新的方法）
        registry.addInterceptor(customHandlerInterceptor).addPathPatterns("/*");
//        registry.addInterceptor(customHandlerInterceptor).addPathPatterns("/*");
//        registry.addInterceptor(customHandlerInterceptor).addPathPatterns("/*");
    }
}
