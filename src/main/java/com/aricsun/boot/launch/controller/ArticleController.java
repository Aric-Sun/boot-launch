package com.aricsun.boot.launch.controller;

import com.aricsun.boot.launch.AjaxResponse;
import com.aricsun.boot.launch.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author AricSun
 * @date 2020.12.04 22:18
 */
@Slf4j
@RestController
@RequestMapping("/rest")  // 相当于下面路径的前缀
public class ArticleController {
    //查询一篇文章，根据id
//    @RequestMapping(value = "/articles/{id}", method = RequestMethod.GET)
    @GetMapping("/articles/{id}")
    public AjaxResponse getArticle(@PathVariable("id") Long id){  // PathVariable表示传递的是路径上的变量
        Article article = Article.builder()
                .id(1L)
                .author("aricSun")
                .content("路径选择工具：U")
                .createTime(new Date())
                .title("PS基本工具")
                .build();

        log.info("article: "+ article);

        return AjaxResponse.success(article);
    }

    //新增一篇文章
//    @RequestMapping(value = "/articles", method = RequestMethod.POST)
    @PostMapping("/articles")
    public AjaxResponse saveArticle(@RequestBody Article article,  // RequestBody接收来自http的一个对象，可嵌套（json）
                                    @RequestHeader String aaa){  // RequestHeader接收请求头参数

        log.info("saveArticle: "+ article);

        return AjaxResponse.success();
    }
    /*@PostMapping("/articles")
    public AjaxResponse saveArticle(@RequestParam  String author,
                                    @RequestParam  String title,
                                    @RequestParam  String content,
                                    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                                    @RequestParam  Date createTime){  // RequestParam 只能平面的一个一个地来接收参数(form表单和get参数)

        log.info("saveArticle: "+ createTime);

        return AjaxResponse.success();
    }*/

    //更新一篇文章
//    @RequestMapping(value = "/articles", method = RequestMethod.PUT)
    @PutMapping("/articles")
    public AjaxResponse updateArticle(@RequestBody Article article){
        if (article.getId() == null){
            //TODO: 抛出一个自定义异常
        }

        log.info("updateArticle: "+ article);

        return AjaxResponse.success();
    }

    //删除一篇文章，根据id
//    @RequestMapping(value = "/articles/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/articles/{id}")
    public AjaxResponse deleteArticle(@PathVariable("id") Long id){

        log.info("deleteArticle: "+ id);

        return AjaxResponse.success();
    }
}
