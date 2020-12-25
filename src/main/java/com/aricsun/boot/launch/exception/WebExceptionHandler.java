package com.aricsun.boot.launch.exception;

import com.aricsun.boot.launch.AjaxResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 自定义异常处理 以及 异常兜底处理
 * 全局异常处理通用逻辑，所有的异常都会被此类捕获
 * @author AricSun
 * @date 2020.12.26 0:34
 */
@RestControllerAdvice // 这个注解和下面的ExceptionHandler一起，
// 作用是：Spring Boot中抛出的异常是自定义的异常时，交给如下方法处理

/* org.springframework.web.bind.annotation.RestControllerAdvice
注解本身使用@ControllerAdvice和@ResponseBody注解。
使用了@RestControllerAdvice注解的类会被看作一个ControllerAdvice,
而该类中所有使用@ExceptionHandler注解的方法都默认使用@ResponseBody注解。
 */
public class WebExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public AjaxResponse customException(CustomException e){
        if (e.getCode() == CustomExceptionType.SYSTEM_ERROR.getCode()){
            // 400 异常不需要持久化，将异常信息以友好的方式告知用户即可
            // TODO: 将 500 异常信息持久化处理，方便运维人员处理
        }
        return AjaxResponse.error(e);
    }

    //（兜底） 处理程序员在程序中未能捕获（遗漏的）异常
    @ExceptionHandler(Exception.class)
    public AjaxResponse exception(Exception e){
        // TODO:  将异常信息持久化处理，方便运维人员处理
        e.printStackTrace();
        return AjaxResponse.error(new CustomException(
                CustomExceptionType.OTHER_ERROR));
    }
}
