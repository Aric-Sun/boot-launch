package com.aricsun.boot.launch.dao.demo;

import com.aricsun.boot.launch.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * jpa仓库，实现了基本的各个sql方法
 * 测试Spring data rest，搭配spring data jpa（45）
 * @author AricSun
 * @date 2020.12.16 21:38
 */
@RepositoryRestResource(path = "auto-rest")  // 对应教程里的articles
public interface ArticleRepository extends JpaRepository<Article, Long> {

    // 注意这个方法的名称，jPA会根据方法名自动生成SQL执行
    Article findByAuthor(String author);
}
