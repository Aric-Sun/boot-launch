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
//@JsonPropertyOrder(value = {"content", "title"})  // 将value中的字段提前并按value中排列的顺序展示在返回response值上
public class Article {
    /**
     * id : 1
     * author : zimug
     * title : 手摸手教你开发spring boot
     * content : c
     * createTime :
     * reader : [{"name":"zimug","age":18},{"name":"kobe","age":37}]
     */
//    @JsonIgnore  // 忽略敏感的字段，不返回
    private Long id;
    //    @JsonProperty("auther")  // 别名，更改response的接收/返回字段名，输出顺序掉到最后一个
    private String author;
    private String title;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    // 更改此model接收/返回的日期/数字格式（化），用于在全局设置（application-test.yml）下的特殊设置，
    private Date createTime;
    @JsonInclude(JsonInclude.Include.NON_NULL)  // 不返回空的字段
    private List<Reader> reader;
}
