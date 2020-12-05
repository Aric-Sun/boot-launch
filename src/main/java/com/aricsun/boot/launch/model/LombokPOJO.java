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
@Data   // getter setter ���� equal toString
@Slf4j  // ����Logger����
@Builder// �Զ������������src/main/java/com/aricsun/boot/launch/BootLaunchApplication.java
@AllArgsConstructor  // ȫ�εĹ��캯��
//@NoArgsConstructor  //�޲εĹ��캯��
public class LombokPOJO {
    // use @slf4j to override
//    private static final Logger log = LoggerFactory.getLogger(lombokPOJO.class);

    private String name;
    private Integer age;
}
