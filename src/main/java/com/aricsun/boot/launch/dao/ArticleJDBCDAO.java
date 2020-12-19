package com.aricsun.boot.launch.dao;

import com.aricsun.boot.launch.model.demo.Article;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author AricSun
 * @date 2020.12.14 19:54
 */
@Repository
public class ArticleJDBCDAO {

    @Resource
    private JdbcTemplate primaryJdbcTemplate;

    // add article
    public void save(Article article, JdbcTemplate jdbcTemplate){
        if (jdbcTemplate == null){
            jdbcTemplate = primaryJdbcTemplate;
        }
        jdbcTemplate.update("insert into article(author, title, content, create_time) values(?,?,?,?)",
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime());
    }

    // delete article
    public void deleteById(Long id, JdbcTemplate jdbcTemplate){
        if (jdbcTemplate == null){
            jdbcTemplate = primaryJdbcTemplate;
        }
        jdbcTemplate.update("delete from article where id = ?", id);
    }

    // update article
    public void updateById(Article article, JdbcTemplate jdbcTemplate){
        if (jdbcTemplate == null){
            jdbcTemplate = primaryJdbcTemplate;
        }
        jdbcTemplate.update("update article set author=?, title=?, content=?, create_time=? where id = ?",
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime(),
                article.getId());
    }

    public Article findById(Long id, JdbcTemplate jdbcTemplate){
        if (jdbcTemplate == null){
            jdbcTemplate = primaryJdbcTemplate;
        }
        return jdbcTemplate.queryForObject("select * from article where id = ?", new Object[]{id},
                new BeanPropertyRowMapper<>(Article.class));
    }  // queryForObject(), select ONLY ONE record

    public List<Article> findAll(JdbcTemplate jdbcTemplate){
        if (jdbcTemplate == null){
            jdbcTemplate = primaryJdbcTemplate;
        }
        return jdbcTemplate.query("select * from article",
                new BeanPropertyRowMapper<>(Article.class));
    }  // query(), select many records
}
