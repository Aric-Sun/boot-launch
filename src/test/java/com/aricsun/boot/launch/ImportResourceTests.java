package com.aricsun.boot.launch;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;


/**
 * @author AricSun
 * @date 2020.12.13 21:14
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ImportResourceTests {

    @Resource
    private ConfigurableApplicationContext ioc;

    @Test
    public void testImport() throws Exception{
        boolean isImport = ioc.containsBean("testBeanService");
        System.out.println(isImport);
    }
}
