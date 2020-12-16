package com.aricsun.boot.launch;

import com.aricsun.boot.launch.dao.ArticleRepository;
import com.aricsun.boot.launch.model.Article;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

/**
 * @author AricSun
 * @date 2020.12.17 0:47
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class JPAKeyWordTest {
    @Resource
    private ArticleRepository articleRepository;

    @Test
    public void jpaTest(){
        Article article = articleRepository.findByAuthor("zimug");
        System.out.println(article);
    }
}
