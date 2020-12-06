package com.aricsun.boot.launch;

import com.aricsun.boot.launch.controller.ArticleController;
import com.aricsun.boot.launch.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * 添加测试环境下的Spring上下文环境，解决依赖注入问题
 * @author AricSun
 * @date 2020.12.06 15:21
 */
@Slf4j
@AutoConfigureMockMvc  // 自动构建mockmvc对象
@SpringBootTest  // Spring上下文环境
@ExtendWith(SpringExtension.class)  // 提供Spring运行时的Servlet容器环境
// 不加上面三行只能测试controller层面的，如果有@Resource或者@AutoWired之类的Bean的依赖注入，就用上面的注解
public class ArticleRestControllerTest2 {

    @Resource
    private MockMvc mockMvc;

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
                // 解决读不到application.yml的问题导致时间格式报错，就是缺少Spring环境，见类前的三个注解
                "    \"reader\" : [{\"name\":\"zimug\",\"age\":18},{\"name\":\"kobe\",\"age\":37}]\n" +
                "}";

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders
                        .request(HttpMethod.POST, "/rest/articles")
                        .contentType("application/json")
                        .content(article)
        )
                // 期望值，类似于断言assert
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.author").value("zimug"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.reader[0].age").value(18))
                .andDo(print())
                .andReturn();

        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        log.info(mvcResult.getResponse().getContentAsString());
    }
}
