package com.aricsun.boot.launch.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

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
public class ArticleVO {
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
    @NotEmpty(message = "文章内容不能为空")
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    // 更改此model接收/返回的日期/数字格式（化），用于在全局设置（application-test.yml）下的特殊设置，
    private Date createTime;
//    @JsonInclude(JsonInclude.Include.NON_NULL)  // 不返回空的字段
    private List<Reader> reader;

    /*
    JSR 303规范的实现：hibernate validator
    @size（min=6，max=20，message="密码长度只能在6-20之间"）
    @pattern（regexp="[a-za-z0-9._%+-]+@[a-za-z0-9.-]+\[a-za-z]（2，4）"，message=“请输入正确的邮件格式"）
    @Length（min=5，max=20，message="用户名长度必须位于5到20之间"）
    @Email（message=“请输入正确的邮箱"）
    @NotNull（message="用户名称不能为空"”）
    @Max（value=100，message=“年龄不能大于100岁"）
    @Min（value=18，message="必须年满18岁！"）醇
    @AssertTrue（message="bln4 must is true"）
    @AssertFalse（message ="blnf must is falase"）
    @DecimalMax（value="100"，message="decim最大值是100"）@DecimalMin（value="100"，message="decim最小值是100"）
    @NotNull（message="身份证不能为空”）
    @Pattern（regexp="^（d{18，18）\d{15，15l\d{17，17}[xlX]））$"，message="身份证格式错误"）
     */
}
