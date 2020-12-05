package com.aricsun.boot.launch.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author AricSun
 * @date 2020.12.04 17:19
 */
@Data   // getter setter 构造 equal toString
@Slf4j  // 构建Logger对象
@Builder// 自动构建对象，详见src/main/java/com/aricsun/boot/launch/BootLaunchApplication.java
@AllArgsConstructor  // 全参的构造函数
//@NoArgsConstructor  //无参的构造函数
public class LombokPOJO {
    // use @slf4j to override
//    private static final Logger log = LoggerFactory.getLogger(lombokPOJO.class);

    private String name;
    private Integer age;
}
