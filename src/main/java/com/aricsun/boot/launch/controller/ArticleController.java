package com.aricsun.boot.launch.controller;

import com.aricsun.boot.launch.AjaxResponse;
import com.aricsun.boot.launch.model.Article;
import com.aricsun.boot.launch.model.Reader;
import com.aricsun.boot.launch.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author AricSun
 * @date 2020.12.04 22:18
 */
@Slf4j
@RestController
@RequestMapping("/rest")  // �൱������·����ǰ׺
public class ArticleController {

    @Resource
    ArticleService articleService;

    //��ѯһƪ���£�����id
//    @RequestMapping(value = "/articles/{id}", method = RequestMethod.GET)
    @GetMapping("/articles/{id}")
    public AjaxResponse getArticle(@PathVariable("id") Long id){  // PathVariable��ʾ���ݵ���·���ϵı���
        List<Reader> readers = new ArrayList<Reader>(){{  // ʵ����ʼ����
         add(new Reader("kobe", 21));
         add(new Reader("james", 20));
        }};

        Article article = Article.builder()
                .id(1L)
                .author("aricSun")
                .content("·��ѡ�񹤾ߣ�U")
                .createTime(new Date())
                .reader(readers)
                .title("PS��������")
                .build();

        log.info("article: "+ article);

        return AjaxResponse.success(article);
    }

    //����һƪ����
//    @RequestMapping(value = "/articles", method = RequestMethod.POST)
    @PostMapping("/articles")
    public AjaxResponse saveArticle(@RequestBody Article article/*,  // RequestBody��������http��һ�����󣬿�Ƕ�ף�json��
                                    @RequestHeader String aaa*/){  // RequestHeader��������ͷ����

        log.info("saveArticle: "+ article);

        return AjaxResponse.success(articleService.saveArticle(article));
//        return AjaxResponse.success(article);
    }
    /*@PostMapping("/articles")
    public AjaxResponse saveArticle(@RequestParam  String author,
                                    @RequestParam  String title,
                                    @RequestParam  String content,
                                    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                                    @RequestParam  Date createTime){  // RequestParam ֻ��ƽ���һ��һ���������ղ���(form����get����)

        log.info("saveArticle: "+ createTime);

        return AjaxResponse.success();
    }*/

    //����һƪ����
//    @RequestMapping(value = "/articles", method = RequestMethod.PUT)
    @PutMapping("/articles")
    public AjaxResponse updateArticle(@RequestBody Article article){
        if (article.getId() == null){
            //TODO: �׳�һ���Զ����쳣
        }

        log.info("updateArticle: "+ article);

        return AjaxResponse.success();
    }

    //ɾ��һƪ���£�����id
//    @RequestMapping(value = "/articles/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/articles/{id}")
    public AjaxResponse deleteArticle(@PathVariable("id") Long id){

        log.info("deleteArticle: "+ id);

        return AjaxResponse.success();
    }
}
