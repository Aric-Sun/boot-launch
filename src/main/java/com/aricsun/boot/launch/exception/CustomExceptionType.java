package com.aricsun.boot.launch.exception;

/**
 * 枚举异帝分类，将异帝分类固化下来
 * @author AricSun
 * @date 2020.12.25 22:12
 */
public enum CustomExceptionType {

    USER_INPUT_ERROR(400, "您输入的数据错误或您没有权限访问资源！"),
    SYSTEM_ERROR(500, "系统出现异常，请您稍后再试或联系管理员！"),
    OTHER_ERROR(999, "系统出现未知异常，请联系管理员！");

    private String desc; // description  异常类型中文描述
    private int code;

    // 这个构造函数其实是给上面的枚举值用的，不是给其他调用的，只能是private
    CustomExceptionType(int code, String desc) {
        this.desc = desc;
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public int getCode() {
        return code;
    }
}
