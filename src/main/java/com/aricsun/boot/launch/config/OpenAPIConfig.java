package com.aricsun.boot.launch.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author AricSun
 * @date 2020.12.09 21:57
 */

@Configuration
public class OpenAPIConfig {

    @Bean
    public GroupedOpenApi restApi(){
        return GroupedOpenApi.builder()
                .group("rest-api")
                .pathsToMatch("/rest/**")
                .build();
    }

    @Bean
    public GroupedOpenApi helloApi(){
        return GroupedOpenApi.builder()
                .group("hello")
                .pathsToMatch("/hello/**")
                .build();
    }
}
