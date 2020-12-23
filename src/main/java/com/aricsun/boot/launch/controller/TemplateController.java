package com.aricsun.boot.launch.controller;

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

    @GetMapping("/freemarker")
    public String index2(String name, Model model){
        List<ArticleVO> articles = articleService.getAll();
        model.addAttribute("articles", articles);

        // 模板名称，实际的目录为：src/main/resources/templates/freemarkertemp.ftl
        return "freemarkertemp";
    }
}
