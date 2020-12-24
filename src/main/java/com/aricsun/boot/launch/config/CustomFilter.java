package com.aricsun.boot.launch.config;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author AricSun
 * @date 2020.12.24 14:01
 */
@Slf4j
//@WebFilter(filterName = "customFilter", urlPatterns = {"/*"})  // 多个过滤器的执行顺序是按照名字的字典序执行，改用FilterRegistrationBean了
public class CustomFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("Filter 初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        log.info("customFilter 请求处理之前----doFilter方法之前过滤请求");
        servletRequest.setCharacterEncoding("UTF-8");

        filterChain.doFilter(servletRequest, servletResponse);

        servletResponse.setCharacterEncoding("UTF-8");
        log.info("customFilter 请求处理之后----doFilter方法之后处理响应");
    }

    @Override
    public void destroy() {
        log.info("Filter 销毁");
    }
}
