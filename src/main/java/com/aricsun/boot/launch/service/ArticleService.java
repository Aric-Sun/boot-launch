package com.aricsun.boot.launch.service;

import com.aricsun.boot.launch.model.Article;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 测试依赖注入用
 * mock测试
 * @author AricSun
 * @date 2020.12.06 21:17
 */
public interface ArticleService {
    void saveArticle(Article article);

    void deleteArticle(Long id);

    void updateArticle(Article article);

    Article getArticle(Long id);

    List<Article> getAll();
}
