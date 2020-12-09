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
 * ��ʵ��Swagger3��ʱ�򱻷�������
 * @author AricSun
 * @date 2020.12.07 17:02
 *//*

@Configuration
@EnableSwagger2  // ��ʾ�ڵ�ǰ����Ŀ������SwaggerAPI�ĵ�
public class SwaggerConfig {

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("boot launch ��ĿAPI�ĵ�")
                .description("�����ŵ�RESTful���")
                .termsOfServiceUrl("https://github.com/Aric-Sun/boot-launch")
                .version("1.0.0")
                .build();
    }

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // ɨ��basePackage�������"/rest/"·���µ�������Ϊ�ӿ��ĵ�������Ŀ��
                .apis(RequestHandlerSelectors.basePackage("com.aricsun.boot.launch"))
                .paths(PathSelectors.regex("/rest/.*"))
                .build();
    }
}
*/
