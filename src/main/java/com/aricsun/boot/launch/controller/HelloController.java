package com.aricsun.boot.launch.controller;

import com.aricsun.boot.launch.model.LombokPOJO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public String hello(HttpServletRequest request, HttpSession session){

        // codota 自动代码补全示例
//        String path = "a.txt";
//        File file = new File(path);
//        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        // auto filling java call parameter 参数填充示例
//        LombokPOJO l = new LombokPOJO(name, age);
        // 得把注解@NoArgsConstructor注释掉才能用

        //rainbow brackets 彩虹括号代码示例 取消下面的注释查看效果
//        (((((((((((((((((((((((((((((((((((((((((((())))))))))))))))))))))))))))))))))))))))))))

        // 操作attribute
        request.setAttribute("a", "a");
        request.setAttribute("a", "b");
        request.getAttribute("a");
        request.removeAttribute("a");

        // 操作session
        session.setAttribute("c", "c");
        session.getAttribute("c");
        session.invalidate();

        return "hello world--------";
    }
}
