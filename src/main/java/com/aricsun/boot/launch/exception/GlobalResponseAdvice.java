package com.aricsun.boot.launch.exception;

import com.aricsun.boot.launch.AjaxResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 数据返回前端前，做最后一步处理
 * 用于将AjaxResponse返回的code和真正的http状态码统一
 * @author AricSun
 * @date 2020.12.26 2:26
 */

@Component
@ControllerAdvice
public class GlobalResponseAdvice implements ResponseBodyAdvice {

    /*
     * function: 支持哪些方法参数，那些响应类
     * @Param [methodParameter, aClass]
     * @Return boolean
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;  // 如果全部支持，就填true
    }

    /*
     * function: 所有的响应结果都经过这里
     * @Param [o就是传过来的对象，打算返回的响应体, methodParameter, mediaType, aClass, serverHttpRequest, serverHttpResponse]
     * @Return java.lang.Object
     */
    @Override
    public Object beforeBodyWrite(Object o,
                                  MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {
        // 如果响应结果是JSON数据类型
        if (mediaType.equalsTypeAndSubtype(
                MediaType.APPLICATION_JSON)) {
            // 如果响应体是AjaxResponse，那么直接设置状态码，并返回
            if (o instanceof AjaxResponse) {
                serverHttpResponse.setStatusCode(HttpStatus.valueOf(
                        ((AjaxResponse)o).getCode()));
                return o;
            } else {  // 如果不是，那么封装成AjaxResponse并返回
                // 将封装延后进行，降低逻辑复杂度，controller只需要返回对象即可
                serverHttpResponse.setStatusCode(HttpStatus.OK);
                return AjaxResponse.success(o);
            }
        }

        return o;
    }
}
