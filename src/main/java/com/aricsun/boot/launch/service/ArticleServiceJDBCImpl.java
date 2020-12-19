/*
package com.aricsun.boot.launch.service;

import com.aricsun.boot.launch.dao.ArticleJDBCDAO;
import com.aricsun.boot.launch.model.demo.Article;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

*/
/**
 * 因使用spring data jpa 而被废弃
 * @author AricSun
 * @date 2020.12.15 0:08
 *//*

@Service
public class ArticleServiceJDBCImpl implements ArticleService {

    @Resource
    private ArticleJDBCDAO articleJDBCDAO;

    @Resource
    private JdbcTemplate primaryJdbcTemplate;
    @Resource
    private JdbcTemplate secondaryJdbcTemplate;

    @Override
    @Transactional
    public void saveArticle(Article article) {
        articleJDBCDAO.save(article ,primaryJdbcTemplate);
        articleJDBCDAO.save(article ,secondaryJdbcTemplate);

//        int a = 10/0;  // 人为抛出异常，测试分布式事务的原子性
    }

    @Override
    public void deleteArticle(Long id) {
        articleJDBCDAO.deleteById(id, null);
    }

    @Override
    @Transactional
    public void updateArticle(Article article) {
        if (article.getId() == null){
            //TODO: 抛出一个自定义异常
        }
        articleJDBCDAO.updateById(article, null);
        */
/*articleJDBCDAO.deleteById(article.getId());
        articleJDBCDAO.save(article);

        int a = 10/0;  // 人为抛出异常，测试事务的原子性*//*

    }

    @Override
    public Article getArticle(Long id) {
        return articleJDBCDAO.findById(id, null);
    }

    @Override
    public List<Article> getAll() {
        return articleJDBCDAO.findAll(null);
    }
}
*/
