package com.aricsun.boot.launch;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * RESTful��׼�ӿ���Ӧ���ݸ�ʽ
 * @author AricSun
 * @date 2020.12.04 22:51
 */
@Data
public class AjaxResponse {
    private boolean isok;
    private int code;  // 200��400��500
    private String message;
    private Object data;

    public static AjaxResponse success(){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setIsok(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("������Ӧ�ɹ���");
        return ajaxResponse;
    }
    public static AjaxResponse success(Object obj){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setIsok(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("������Ӧ�ɹ���");
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
