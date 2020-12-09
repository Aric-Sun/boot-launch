package com.aricsun.boot.launch;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
//import lombok.NoArgsConstructor;

/**
 * ��Щ������Ϊʵ��swagger3(ȥ��Swagger2���������)
 * RESTful��׼�ӿ���Ӧ���ݸ�ʽ
 * @author AricSun
 * @date 2020.12.04 22:51
 */
@Data
//@ApiModel(value = "ͨ����Ӧ���ݽṹ��")  // ����SwaggerAPI�ĵ���ʾ
public class AjaxResponse {
//    @ApiModelProperty(value = "�����Ƿ���ɹ�")
    private boolean isok;
//    @ApiModelProperty(value = "������Ӧ״̬��", example = "200��400��500")
    private int code;  // 200��400��500
//    @ApiModelProperty(value = "������������Ϣ")
    private String message;
//    @ApiModelProperty(value = "����������")
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
