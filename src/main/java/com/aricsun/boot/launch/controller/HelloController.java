package com.aricsun.boot.launch.controller;

import com.aricsun.boot.launch.model.LombokPOJO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @author AricSun
 * @date 2020.12.04 14:48
 */

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(String name){

        // codota �Զ����벹ȫʾ��
//        String path = "a.txt";
//        File file = new File(path);
//        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        // auto filling java call parameter �������ʾ��
//        LombokPOJO l = new LombokPOJO(name, age);
        // �ð�ע��@NoArgsConstructorע�͵�������

        //rainbow brackets �ʺ����Ŵ���ʾ�� ȡ�������ע�Ͳ鿴Ч��
//        (((((((((((((((((((((((((((((((((((((((((((())))))))))))))))))))))))))))))))))))))))))))

        return "hello world, "+ name;
    }
}
