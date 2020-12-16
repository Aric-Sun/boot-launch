package com.aricsun.boot.launch.dao;

import com.aricsun.boot.launch.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * jpa仓库，实现了基本的各个sql方法
 * @author AricSun
 * @date 2020.12.16 21:38
 */
public interface ArticleRepository extends JpaRepository<Article, Long> {

    // 注意这个方法的名称，jPA会根据方法名自动生成SQL执行
    Article findByAuthor(String author);
}
