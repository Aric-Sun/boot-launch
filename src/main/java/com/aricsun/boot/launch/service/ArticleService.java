package com.aricsun.boot.launch.service;

import com.aricsun.boot.launch.model.Article;
import org.springframework.stereotype.Service;

/**
 * ��������ע����
 * mock����
 * @author AricSun
 * @date 2020.12.06 21:17
 */
public interface ArticleService {
    public String saveArticle(Article article);
}
