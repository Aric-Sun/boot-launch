package com.aricsun.boot.launch.config;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

/**
 * 应用启动监听器的实现方式 3
 * @author AricSun
 * @date 2020.12.24 16:35
 */
@Configuration
public class BeanRunner {

    @Bean  // 应用启动监听器的实现方式 3
    @Order(1)  // 指定执行顺序
    public CommandLineRunner runner1(){
        return args -> System.out.println("BeanCommandLineRunner run1()" + Arrays.toString(args));
    }

    @Bean
    @Order(2)  // 只能保证 同类CommandLineRunner 的顺序，不能跨类同时保证其他类ApplicationRunner的执行顺序
    public CommandLineRunner runner2(){
        return args -> System.out.println("BeanCommandLineRunner run2()" + Arrays.toString(args));
    }

    @Bean
    @Order(3)
    public ApplicationRunner runner3(){
        return args -> System.out.println("BeanApplicationRunner run3" + Arrays.toString(args.getSourceArgs()));
    }
}
