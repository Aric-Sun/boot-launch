package com.aricsun.boot.launch;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
import com.aricsun.boot.launch.exception.CustomException;
import com.aricsun.boot.launch.exception.CustomExceptionType;
import lombok.Data;
//import lombok.NoArgsConstructor;

/**
 * 有些内容因为实现swagger3(去掉Swagger2的相关内容)
 * RESTful标准接口响应数据格式
 * @author AricSun
 * @date 2020.12.04 22:51
 */
@Data
//@ApiModel(value = "通用响应数据结构类")  // 用于SwaggerAPI文档显示
public class AjaxResponse {
//    @ApiModelProperty(value = "请求是否处理成功")
    private boolean isok;
//    @ApiModelProperty(value = "请求响应状态码", example = "200、400、500")
    private int code;  // 200、400、500
//    @ApiModelProperty(value = "请求结果描述信息")
    private String message;
//    @ApiModelProperty(value = "请求结果数据")
    private Object data;

    private AjaxResponse(){}

    public static AjaxResponse error(CustomException e){
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setIsok(false);
        resultBean.setCode(e.getCode());
        resultBean.setMessage(e.getMessage());
        return resultBean;
    }

    /*
     * function: 可以将错误信息翻译（面向用户友好）的时机推迟到调用此方法的时候
     * 即：在写功能代码的时候，可以在手动抛出异常的时候写上错误信息，也可以在返回给前端的时候再写上
     * 一共三层，1，枚举类里默认的，2. 异常类写上的， 3. 调用ajaxResponse返回时写的
     * 从左往右依次覆盖左边的信息
     * @Param [customExceptionType, errorMessage]
     * @Return com.aricsun.boot.launch.AjaxResponse
     */
    public static AjaxResponse error(CustomExceptionType customExceptionType,
                                     String errorMessage){
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setIsok(false);
        resultBean.setCode(customExceptionType.getCode());
        resultBean.setMessage(errorMessage);
        return resultBean;
    }

    public static AjaxResponse success(){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setIsok(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("请求响应成功！");
        return ajaxResponse;
    }
    public static AjaxResponse success(Object obj){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setIsok(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("请求响应成功！");
        ajaxResponse.setData(obj);
        return ajaxResponse;
    }
    public static AjaxResponse success(Object obj, String message){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setIsok(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage(message);
        ajaxResponse.setData(obj);
        return ajaxResponse;
    }
}
