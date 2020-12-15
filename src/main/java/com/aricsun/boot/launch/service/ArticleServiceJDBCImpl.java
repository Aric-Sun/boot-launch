package com.aricsun.boot.launch.service;

import com.aricsun.boot.launch.dao.ArticleJDBCDAO;
import com.aricsun.boot.launch.model.Article;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author AricSun
 * @date 2020.12.15 0:08
 */
@Service
public class ArticleServiceJDBCImpl implements ArticleService {

    @Resource
    private ArticleJDBCDAO articleJDBCDAO;

    @Override
    public void saveArticle(Article article) {
        articleJDBCDAO.save(article);
    }

    @Override
    public void deleteArticle(Long id) {
        articleJDBCDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void updateArticle(Article article) {
        if (article.getId() == null){
            //TODO: 抛出一个自定义异常
        }
        articleJDBCDAO.updateById(article);
        /*articleJDBCDAO.deleteById(article.getId());
        articleJDBCDAO.save(article);

        int a = 10/0;  // 认为抛出异常，测试事务的原子性*/
    }

    @Override
    public Article getArticle(Long id) {
        return articleJDBCDAO.findById(id);
    }

    @Override
    public List<Article> getAll() {
        return articleJDBCDAO.findAll();
    }
}
