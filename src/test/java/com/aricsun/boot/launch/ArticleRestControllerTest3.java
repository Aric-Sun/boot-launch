package com.aricsun.boot.launch;

import com.aricsun.boot.launch.controller.ArticleController;
import com.aricsun.boot.launch.model.Article;
import com.aricsun.boot.launch.service.ArticleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * mock测试
 * @author AricSun
 * @date 2020.12.06 15:21
 */
@Slf4j
@AutoConfigureMockMvc  // 自动构建mockmvc对象
@WebMvcTest(ArticleController.class)  // 缩小加载进来的bean的范围，达到轻量级的效果.括号内选定的话就只加载这一个
@ExtendWith(SpringExtension.class)  // 提供Spring运行时的Servlet容器环境
// 不加上面三行只能测试controller层面的，如果有@Resource或者@AutoWired之类的Bean的依赖注入，就用上面的注解
public class ArticleRestControllerTest3 {

    @Resource
    private MockMvc mockMvc;

    @MockBean  // 模拟其行为
    private ArticleService articleService;

    /*@BeforeAll  // 相当于构造方法
    static void setUP(){
        // 针对ArticleController这个控制层进行测试
        mockMvc = MockMvcBuilders.standaloneSetup(new ArticleController()).build();
    }*/

    @Test
    public void saveArticle() throws Exception{
        String article = "{\n" +
                "    \"id\" : \"1\",\n" +
                "    \"author\" : \"zimug\",\n" +
                "    \"title\" : \"手摸手教你开发spring boot\",\n" +
                "    \"content\" : \"c\",\n" +
                "    \"createTime\" : \"2020-12-05 13:05:24\",\n" +
                // 又读不到application.yml了，mockBean一加入就这样了，可能模拟接口注入的时候跳过了一些东西
                // 暂时先不追究了，估计不是什么大问题，先用JsonFormat写死了
                "    \"reader\" : [{\"name\":\"zimug\",\"age\":18},{\"name\":\"kobe\",\"age\":37}]\n" +
                "}";

        // json -> Java
        ObjectMapper mapper = new ObjectMapper();
        Article articleObj = mapper.readValue(article, Article.class);

        //mock打桩（设置条件）
        when(articleService.saveArticle(articleObj)).thenReturn("ok");

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders
                        .request(HttpMethod.POST, "/rest/articles")
                        .contentType("application/json")
                        .content(article)
        )
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").value("ok"))
                .andDo(print())
                .andReturn();

        //模拟get请求
//        mockMvc.perform(MockMvcRequestBuilders.get("/user/{id}"),userId);
        // 模拟post请求
//        mockMvc.perform(MockMvcRequestBuilders.post("uri"),parameters);
        // 模拟文件上传
//        mockMvc.perform(MockMvcRequestBuilders.multipart("uri").file("fileName", "file".getBytes("UTF-8")));;
        // 模拟session和cookie
//        mockMvc.perform(MockMvcRequestBuilders.get("uri").sessionAttr("name", "value"));
//        mockMvc.perform(MockMvcRequestBuilders.get("uri").cookie(new Cookie("name", "value")));
        // 设置http header
        /*mockMvc.perform(
                MockMvcRequestBuilders
                        .get("uri", parameters)
                        .contentType("application/json")
                        .accept("application/json")
                        .header("", "")
        );*/

        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        log.info(mvcResult.getResponse().getContentAsString());
    }
}
