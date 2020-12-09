package com.aricsun.boot.launch.controller;

import com.aricsun.boot.launch.AjaxResponse;
import com.aricsun.boot.launch.model.Article;
import com.aricsun.boot.launch.model.Reader;
import com.aricsun.boot.launch.service.ArticleService;
//import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 由于Swagger3（OpenAPI3.0）的实现，Swagger2部分的注解被注释掉了
 * @author AricSun
 * @date 2020.12.04 22:18
 */
@Slf4j
@RestController
@RequestMapping("/rest")  // 相当于下面路径的前缀
public class ArticleController {

//    @Resource
//    ArticleService articleService;

    //查询一篇文章，根据id
//    @RequestMapping(value = "/articles/{id}", method = RequestMethod.GET)
    @GetMapping("/articles/{id}")
    public AjaxResponse getArticle(@PathVariable("id") Long id){  // PathVariable表示传递的是路径上的变量
        List<Reader> readers = new ArrayList<Reader>(){{  // 实例初始化器
         add(new Reader("kobe", 21));
         add(new Reader("james", 20));
        }};

        Article article = Article.builder()
                .id(1L)
                .author("aricSun")
                .content("路径选择工具：U")
                .createTime(new Date())
                .reader(readers)
                .title("PS基本工具")
                .build();

        log.info("article: "+ article);

        return AjaxResponse.success(article);
    }

    //新增一篇文章
//    @RequestMapping(value = "/articles", method = RequestMethod.POST)
    @PostMapping("/articles")
    public AjaxResponse saveArticle(@RequestBody Article article/*,  // RequestBody接收来自http的一个对象，可嵌套（json）
                                    @RequestHeader String aaa*/){  // RequestHeader接收请求头参数

        log.info("saveArticle: "+ article);

//        return AjaxResponse.success(articleService.saveArticle(article));
        return AjaxResponse.success(article);
    }

    /*@ApiOperation(value = "添加文章", notes = "添加新的文章", tags = "Article", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "文章标题", required = true, dataType = "String"),
            @ApiImplicitParam(name = "content", value = "文章内容", required = true, dataType = "String"),
            @ApiImplicitParam(name = "author", value = "文章作者", required = true, dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功", response = AjaxResponse.class),
    })*/
    @PostMapping("/articles2")
    public AjaxResponse saveArticle(@RequestParam  String author,
                                    @RequestParam  String title,
                                    @RequestParam  String content,
                                    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                                    @RequestParam  Date createTime){  // RequestParam 只能平面的一个一个地来接收参数(form表单和get参数)

        log.info("saveArticle: "+ createTime);

        return AjaxResponse.success();
    }

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
