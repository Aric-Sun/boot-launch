package com.aricsun.boot.launch.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * PO
 * 测试Spring data rest，搭配spring data jpa（45）
 * @author AricSun
 * @date 2020.12.04 21:58
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity  // 实体类，接收SpringDataJPA的管理，对应数据库里的一张表
@Table(name = "article")
public class Article {
    @Id  // 主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //自增
    private Long id;
    @Column(nullable = false, length = 32)
    private String author;
    @Column(nullable = false, unique = true, length = 32)
    private String title;
    @Column(length = 512)
    private String content;
    private Date createTime;
}
