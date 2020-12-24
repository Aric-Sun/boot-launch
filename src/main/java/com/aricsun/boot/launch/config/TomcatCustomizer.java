package com.aricsun.boot.launch.config;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 调整嵌入式容器（Tomcat等）的运行参数，第2种方法，自定义配置类
 * @author AricSun
 * @date 2020.12.25 0:15
 */
@Configuration
public class TomcatCustomizer {

    @Bean
    public ConfigurableServletWebServerFactory configurableServletWebServerFactory(){
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        // 支持更多api，比第一种方式（修改配置文件）有更多的选择，键入【factory.】即可查看api
        factory.addConnectorCustomizers(new MyTomcatConnectionCustomizer());
        return factory;
    }

    static class MyTomcatConnectionCustomizer implements TomcatConnectorCustomizer {

        public MyTomcatConnectionCustomizer() {
        }

        @Override
        public void customize(Connector connector) {
            connector.setPort(Integer.parseInt("8888"));
            connector.setProperty("maxConnections", "8192");
            connector.setProperty("acceptorThreadCount", "100");
            connector.setProperty("minSpareThreads", "10");
            connector.setProperty("maxThreads", "200");
        }
    }
}
