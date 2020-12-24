package com.aricsun.boot.launch.model;

import com.aricsun.boot.launch.service.MixPropertySourceFactory;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;


/**
 * @author AricSun
 * @date 2020.12.12 16:46
 */
@Data
@Component
@PropertySource(value = "classpath:application.yml", ignoreResourceNotFound = true, encoding = "UTF-8")
@Validated
@ConfigurationProperties(prefix = "family")
@PropertySource(value = "classpath:otherconfig/family.yml", factory = MixPropertySourceFactory.class)
public class Family {

//    @Value("${family.family-name}")

    @NotEmpty
    private String familyName;
    private Father father;
    private Mother mother;
    private Child child;

}
