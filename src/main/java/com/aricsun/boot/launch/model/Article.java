package com.aricsun.boot.launch.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author AricSun
 * @date 2020.12.04 21:58
 */
@Data
@Builder
public class Article {
    /**
     * id : 1
     * author : zimug
     * title : 手摸手教你开发spring boot
     * content : c
     * createTime :
     * reader : [{"name":"zimug","age":18},{"name":"kobe","age":37}]
     */
    private Long id;
    private String author;
    private String title;
    private String content;
    private Date createTime;
    private List<Reader> reader;
}
