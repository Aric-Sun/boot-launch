package com.aricsun.boot.launch.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author AricSun
 * @date 2020.12.12 16:46
 */
@Data
@Component
@PropertySource(value = "classpath:application.yml", ignoreResourceNotFound = true, encoding = "UTF-8")
@ConfigurationProperties(prefix = "family")
public class Family {

//    @Value("${family.family-name}")

    private String familyName;
    private Father father;
    private Mother mother;
    private Child child;

}
