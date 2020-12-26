package com.aricsun.boot.launch.exception;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 面向切面编程AOP
 * 对@ModelView的逻辑进行设置
 * 让标注了ModelView的方法成为AOP的切入点
 * @author AricSun
 * @date 2020.12.26 17:05
 */
@Aspect
@Component
@Slf4j
public class ModelViewAspect {

    /*
     * function:设置切入点：这里直接拦截放@ModelView注解的方法
     * @Param []
     * @Return void
     */
    @Pointcut("@annotation(com.aricsun.boot.launch.exception.ModelView)")
    public void pointcut() { }

    /*
     * function:当有ModelView的注解的方法抛出异常的时候，做如下的处理
     * @Param [e]
     * @Return void
     */
    @AfterThrowing(pointcut = "pointcut()", throwing = "e")
    public void afterThrowable(Throwable e) {
        throw ModelViewException.transfer(e);
    }
}
