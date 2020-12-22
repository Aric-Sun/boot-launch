//package com.aricsun.boot.launch;
//
//import com.aricsun.boot.launch.dao.demo.ArticleRepository;
//import com.aricsun.boot.launch.dao.demo2.MessageRepository;
//import com.aricsun.boot.launch.model.demo.Article;
//import com.aricsun.boot.launch.model.demo2.Message;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import javax.annotation.Resource;
//import java.util.Date;
//
///**
// * @author AricSun
// * @date 2020.12.17 0:47
// */
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//public class JPAKeyWordTest {
//    @Resource
//    private ArticleRepository articleRepository;
//
//    @Resource
//    private MessageRepository messageRepository;
//
//    /*
//     * function: JPA关键词查询
//     * @Param []
//     * @Return void
//     */
//    @Test
//    public void jpaTest(){
//        Article article = articleRepository.findByAuthor("zimug");
//        System.out.println(article);
//    }
//
//    /*
//     * function: JPA多数据源测试
//     * @Param []
//     * @Return void
//     */
//    @Test
//    public void jpaTest2(){
//        Article article = Article.builder()
//                .id(2L)
//                .author("zimug")
//                .content("sb, 从青铜到王者")
//                .createTime(new Date())
//                .title("t1")
//                .build();
//        Message message = Message.builder()
//                .name("zimug")
//                .content("OK")
//                .build();
//
//        // 先构造一个Article对象article，这个操作针对demo
//        articleRepository.save(article);
//        // 再构造一个Message对象 message，这个操作针对 demo2
//        messageRepository.save(message);
//    }
//}
