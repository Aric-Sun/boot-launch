package com.aricsun.boot.launch;

import com.aricsun.boot.launch.model.Employee;
import com.aricsun.boot.launch.model.Family;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

/**
 * @author AricSun
 * @date 2020.12.12 16:48
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ValueBindTests {

    @Resource
    Family family;

    @Resource
    Employee employee;

    @Test
    public void valueBindTests() throws Exception{
        System.out.println(family.toString());
    }

    @Test
    public void valueBindTests2() throws Exception{
        System.out.println(employee.toString());
    }
}
