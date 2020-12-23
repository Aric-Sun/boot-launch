package com.aricsun.boot.launch.config;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author AricSun
 * @date 2020.12.24 2:02
 */
@Slf4j
@WebListener
public class CustomListener implements  ServletContextListener,
        ServletRequestListener,
        HttpSessionListener,
        ServletRequestAttributeListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("=====================context创建");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("=====================context销毁");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        log.info("+++++++++++++++++++++++request监听器：销毁");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        log.info("+++++++++++++++++++++++request监听器：创建");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        log.info("-----------------------session创建");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        log.info("-----------------------session销毁");
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        log.info("######################attributeAdded");
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        log.info("#####################attributeRemoved");
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        log.info("#####################attributeReplaced");
    }
}
