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
 * @author AricSun
 * @date 2020.12.24 0:11
 */
@Controller
@RequestMapping("/template")
public class TemplateController {
    @Resource
    ArticleService articleService;

    @GetMapping("/thymeleaf")
    public String index(String name, Model model){
        List<ArticleVO> articles = articleService.getAll();
        model.addAttribute("articles", articles);

        // 模板名称，实际的目录为：src/main/resources/templates/thymeleaftemp.html
        return "thymeleaftemp";
    }
}