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
 * mock����
 * @author AricSun
 * @date 2020.12.06 15:21
 */
@Slf4j
@AutoConfigureMockMvc  // �Զ�����mockmvc����
@WebMvcTest(ArticleController.class)  // ��С���ؽ�����bean�ķ�Χ���ﵽ��������Ч��.������ѡ���Ļ���ֻ������һ��
@ExtendWith(SpringExtension.class)  // �ṩSpring����ʱ��Servlet��������
// ������������ֻ�ܲ���controller����ģ������@Resource����@AutoWired֮���Bean������ע�룬���������ע��
public class ArticleRestControllerTest3 {

    @Resource
    private MockMvc mockMvc;

    @MockBean  // ģ������Ϊ
    private ArticleService articleService;

    /*@BeforeAll  // �൱�ڹ��췽��
    static void setUP(){
        // ���ArticleController������Ʋ���в���
        mockMvc = MockMvcBuilders.standaloneSetup(new ArticleController()).build();
    }*/

    @Test
    public void saveArticle() throws Exception{
        String article = "{\n" +
                "    \"id\" : \"1\",\n" +
                "    \"author\" : \"zimug\",\n" +
                "    \"title\" : \"�����ֽ��㿪��spring boot\",\n" +
                "    \"content\" : \"c\",\n" +
                "    \"createTime\" : \"2020-12-05 13:05:24\",\n" +
                // �ֶ�����application.yml�ˣ�mockBeanһ����������ˣ�����ģ��ӿ�ע���ʱ��������һЩ����
                // ��ʱ�Ȳ�׷���ˣ����Ʋ���ʲô�����⣬����JsonFormatд����
                "    \"reader\" : [{\"name\":\"zimug\",\"age\":18},{\"name\":\"kobe\",\"age\":37}]\n" +
                "}";

        // json -> Java
        ObjectMapper mapper = new ObjectMapper();
        Article articleObj = mapper.readValue(article, Article.class);

        //mock��׮������������
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

        //ģ��get����
//        mockMvc.perform(MockMvcRequestBuilders.get("/user/{id}"),userId);
        // ģ��post����
//        mockMvc.perform(MockMvcRequestBuilders.post("uri"),parameters);
        // ģ���ļ��ϴ�
//        mockMvc.perform(MockMvcRequestBuilders.multipart("uri").file("fileName", "file".getBytes("UTF-8")));;
        // ģ��session��cookie
//        mockMvc.perform(MockMvcRequestBuilders.get("uri").sessionAttr("name", "value"));
//        mockMvc.perform(MockMvcRequestBuilders.get("uri").cookie(new Cookie("name", "value")));
        // ����http header
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
