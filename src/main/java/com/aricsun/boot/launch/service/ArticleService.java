package com.aricsun.boot.launch.service;

import com.aricsun.boot.launch.model.Article;
import com.aricsun.boot.launch.model.ArticleVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 测试依赖注入用
 * mock测试
 * spring data jpa
 * @author AricSun
 * @date 2020.12.06 21:17
 */
public interface ArticleService {
    void saveArticle(ArticleVO article);

    void deleteArticle(Long id);

    void updateArticle(ArticleVO article);

    ArticleVO getArticle(Long id);

    List<ArticleVO> getAll();
}
