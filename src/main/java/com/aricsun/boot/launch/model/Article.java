package com.aricsun.boot.launch.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author AricSun
 * @date 2020.12.04 21:58
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder(value = {"content", "title"})  // ��value�е��ֶ���ǰ����value�����е�˳��չʾ�ڷ���responseֵ��
public class Article {
    /**
     * id : 1
     * author : zimug
     * title : �����ֽ��㿪��spring boot
     * content : c
     * createTime :
     * reader : [{"name":"zimug","age":18},{"name":"kobe","age":37}]
     */
    @JsonIgnore  // �������е��ֶΣ�������
    private Long id;
    @JsonProperty("auther")  // ����������response���ֶ��������˳��������һ��
    private String author;
    private String title;
    private String content;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
    // ���Ĵ�model���ص�����/���ָ�ʽ��������������ȫ�����ã�application.yml���µ��������ã�
    private Date createTime;
    @JsonInclude(JsonInclude.Include.NON_NULL)  // �����ؿյ��ֶ�
    private List<Reader> reader;
}
