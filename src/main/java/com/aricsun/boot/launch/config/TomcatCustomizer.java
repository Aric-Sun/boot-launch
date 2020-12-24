package com.aricsun.boot.launch.config;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 调整嵌入式容器（Tomcat等）的运行参数，第2种方法，自定义配置类
 * 配置http端口，使其能够跳转到https的8888端口上（P60）
 * @author AricSun
 * @date 2020.12.25 0:15
 */
@Configuration
public class TomcatCustomizer {

    @Value("${server.httpPort}")
    int httpPort;
    @Value("${server.port}")
    int httpsPort;

    @Bean
    public ConfigurableServletWebServerFactory configurableServletWebServerFactory(){
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory(){
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint constraint = new SecurityConstraint();
                constraint.setUserConstraint("CONFIDENTIAL");  // 用户约束：需要认证

                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");  // 所有路径都认证
                constraint.addCollection(collection);
                context.addConstraint(constraint);
            }
        };
//        // 支持更多api，比第一种方式（修改配置文件）有更多的选择，键入【factory.】即可查看api
//        factory.addConnectorCustomizers(new MyTomcatConnectionCustomizer());
        factory.addAdditionalTomcatConnectors(connector());
        return factory;
    }

    // 链接定制器
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

    // 链接器
    public Connector connector(){
        Connector connector = new Connector(Http11NioProtocol.class.getName());
        connector.setScheme("http");
        connector.setPort(httpPort);
        connector.setSecure(false);
        // 听到http的端口号后转向到的https的端口号
        connector.setRedirectPort(httpsPort);
        return connector;
    }
}
