package com.aricsun.boot.launch.exception;

/**
 * @author AricSun
 * @date 2020.12.25 22:31
 */
public class CustomException extends RuntimeException{
    private int code;
    private String message;

    // 私有的无参构造函数，不能让程序员随便生成
    private CustomException(){}

    public CustomException(CustomExceptionType exceptionTypeEnum) {
        code = exceptionTypeEnum.getCode();
        message = exceptionTypeEnum.getDesc();
    }

    public CustomException(CustomExceptionType exceptionTypeEnum,
                           String message) {
        this.code = exceptionTypeEnum.getCode();
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
