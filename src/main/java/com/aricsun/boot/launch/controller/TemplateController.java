package com.aricsun.boot.launch.controller;

import com.aricsun.boot.launch.exception.CustomException;
import com.aricsun.boot.launch.exception.CustomExceptionType;
import com.aricsun.boot.launch.exception.ModelView;
import com.aricsun.boot.launch.model.ArticleVO;
import com.aricsun.boot.launch.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * 整合jsp到spring boot（48）
 * @author AricSun
 * @date 2020.12.23 22:16
 */
@Controller
@RequestMapping("/template")
public class TemplateController {
    @Resource
    ArticleService articleService;

    @GetMapping("/jsp")
    public String index(String name, Model model){
        List<ArticleVO> articles = articleService.getAll();
        model.addAttribute("articles", articles);

        // 模板名称，实际的目录为：src/main/webapp/WEB-INF/jsp/jsptemp.jsp
        return "jsptemp";
    }

    @ModelView  // AOP面向切面编程，抛出异常会跳转到ModelViewException并跳转到error.html，不会变成json数据返回出去
    @GetMapping("/freemarker")
    public String index2(String name, Model model){

        // 人为的抛出异常，测试ModelView（68）
        if (1==1){
            throw new CustomException(CustomExceptionType.SYSTEM_ERROR);
        }

        List<ArticleVO> articles = articleService.getAll();
        model.addAttribute("articles", articles);

        // 模板名称，实际的目录为：src/main/resources/templates/freemarkertemp.ftl
        // 根据模板名称在设置的目录（yml指定）下，找到名字一样的，再把后缀和yml里匹配
        // 一般不会多个模板引擎一起使用，但是名字最好不要起一样的
        return "freemarkertemp";
    }
}
