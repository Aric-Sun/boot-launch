package com.aricsun.boot.launch.exception;

import java.lang.annotation.*;

/**
 * 自定义注解（P68）
 * 面向切面编程（AOP）的实现，@ModelView作为一个标识，把页面级别的异常转换为modelException，
 * 使得可以在使用模板（thymeleaf、freemarker）或jsp时，可以与统一json返回接口并存，
 * 使得可以跳转到error.html这类的统一页面上
 * @author AricSun
 * @date 2020.12.26 16:54
 */
@Documented  // 定义自定义注解需要用的注解
@Retention(RetentionPolicy.RUNTIME)  // 表明在运行时使用
@Target({ElementType.METHOD})  // 表示注解在方法上
public @interface ModelView {
    // 只是作为标记，本身没有任何的逻辑
}
