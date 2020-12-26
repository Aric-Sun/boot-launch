package com.aricsun.boot.launch.exception;

import com.aricsun.boot.launch.AjaxResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义异常处理 以及 异常兜底处理
 * 全局异常处理通用逻辑，所有的异常都会被此类捕获
 * @author AricSun
 * @date 2020.12.26 0:34
 */
@ControllerAdvice // 这个注解和下面的ExceptionHandler一起，
// 作用是：Spring Boot中抛出的异常是自定义的异常时，交给如下方法处理

/* org.springframework.web.bind.annotation.RestControllerAdvice
注解本身使用@ControllerAdvice和@ResponseBody注解。
使用了@RestControllerAdvice注解的类会被看作一个ControllerAdvice,
而该类中所有使用@ExceptionHandler注解的方法都默认使用@ResponseBody注解。
 */
public class WebExceptionHandler {

    /*
     * function: 针对页面类型的异常跳转，针对模板引擎的AOP
     * 标注modelView注解的方法如果抛出异常，会被此方法处理
     * 跳转到统一的error.html/ftl/jsp这种页面上
     * @Param [req, e]
     * @Return org.springframework.web.servlet.ModelAndView
     */
    @ExceptionHandler(ModelViewException.class)
    public ModelAndView viewExceptionHandler(HttpServletRequest req, ModelViewException e) {
        ModelAndView modelAndView = new ModelAndView();

        // 将异常信息设置如modelAndView
        modelAndView.addObject("exception", e);
        modelAndView.addObject("url", req.getRequestURL());
        modelAndView.setViewName("error");

        return modelAndView;
    }

    /*
     * function: 专门针对数据校验的异常。校验设置在VO的参数前注解和函数的参数定义时的@Valid注解
     * @Param [MethodArgumentNotValidException]
     * @Return com.aricsun.boot.launch.AjaxResponse
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public AjaxResponse handleBindException(MethodArgumentNotValidException e){
        FieldError fieldError = e.getBindingResult().getFieldError();
        return AjaxResponse.error(new CustomException(CustomExceptionType.USER_INPUT_ERROR,
                fieldError.getDefaultMessage())); // 这个defaultMessage就是@NotEmpty的message信息
    }

    /*
     * function: 和上面的方法一模一样，因为参数校验可能抛出这两个异常，所以都要捕获到
     * @Param [BindException]
     * @Return com.aricsun.boot.launch.AjaxResponse
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public AjaxResponse handleBindException(BindException e){
        FieldError fieldError = e.getBindingResult().getFieldError();
        return AjaxResponse.error(new CustomException(CustomExceptionType.USER_INPUT_ERROR,
                fieldError.getDefaultMessage())); // 这个defaultMessage就是@NotEmpty的message信息
    }

    /*
     * function: 针对org.springframework.util.Assert抛出的异常进行捕获
     * @Param [IllegalArgumentException]
     * @Return com.aricsun.boot.launch.AjaxResponse
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public AjaxResponse handleIllegalArgumentException(IllegalArgumentException e){
        return AjaxResponse.error(
                new CustomException(CustomExceptionType.USER_INPUT_ERROR,
                        e.getMessage()));
    }

    /*
     * function: 针对自定义异常的捕获
     * @Param [CustomException]
     * @Return com.aricsun.boot.launch.AjaxResponse
     */
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public AjaxResponse customException(CustomException e){
        if (e.getCode() == CustomExceptionType.SYSTEM_ERROR.getCode()){
            // 400 异常不需要持久化，将异常信息以友好的方式告知用户即可
            // TODO: 将 500 异常信息持久化处理，方便运维人员处理
        }
        return AjaxResponse.error(e);
    }

    //（兜底） 处理程序员在程序中未能捕获（遗漏的）异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public AjaxResponse exception(Exception e){
        // TODO:  将异常信息持久化处理，方便运维人员处理
        e.printStackTrace();
        return AjaxResponse.error(new CustomException(
                CustomExceptionType.OTHER_ERROR));
    }
}
