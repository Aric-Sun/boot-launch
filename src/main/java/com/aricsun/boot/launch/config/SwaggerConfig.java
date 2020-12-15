/*
package com.aricsun.boot.launch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

*/
/**
 * 在实现Swagger3的时候被废弃不用
 * @author AricSun
 * @date 2020.12.07 17:02
 *//*

@Configuration
@EnableSwagger2  // 表示在当前的项目中启用SwaggerAPI文档
public class SwaggerConfig {

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("boot launch 项目API文档")
                .description("简单优雅的RESTful风格")
                .termsOfServiceUrl("https://github.com/Aric-Sun/boot-launch")
                .version("1.0.0")
                .build();
    }

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 扫描basePackage包下面的"/rest/"路径下的内容作为接口文档构建的目标
                .apis(RequestHandlerSelectors.basePackage("com.aricsun.boot.launch"))
                .paths(PathSelectors.regex("/rest/.*"))
                .build();
    }
}
*/
