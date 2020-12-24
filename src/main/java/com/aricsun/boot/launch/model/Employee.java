package com.aricsun.boot.launch.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.Map;

/**
 * @author AricSun
 * @date 2020.12.14 13:56
 */
@Data
@Configuration
@PropertySource(value = "classpath:otherconfig/employee.properties", encoding = "UTF-8")
public class Employee {

    @Value("#{'${employee.names}'.split('\\|')}")  // SpEL, split with '|'
    private List<String> employeeNames;

    @Value("#{'${employee.names}'.split('\\|')[0]}")  // select the 1st element
    private String firstEmployeeName;

    @Value("#{${employee.age}}")
    private Map<String, Integer> employeeAge;  // String can be convert to Integer automatically

    @Value("#{${employee.age}.two}")
//    @Value("#{${employee.age}['two']}")  // both right
    private String employeeAgeTwo;

    @Value("#{${employee.age}['five']?:31}") // return 31 if the 5th element dos not exist
    private Integer ageWithDefaultValue;

    @Value("#{systemProperties['java.home']}")  // return JRE dir
    private String javaHome;

    @Value("#{systemProperties['user.dir']}")  // return current project root dir
    private String userDir;
}
