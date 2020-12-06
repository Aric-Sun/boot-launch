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
 * ��Ӳ��Ի����µ�Spring�����Ļ������������ע������
 * @author AricSun
 * @date 2020.12.06 15:21
 */
@Slf4j
@AutoConfigureMockMvc  // �Զ�����mockmvc����
@SpringBootTest  // Spring�����Ļ���
@ExtendWith(SpringExtension.class)  // �ṩSpring����ʱ��Servlet��������
// ������������ֻ�ܲ���controller����ģ������@Resource����@AutoWired֮���Bean������ע�룬���������ע��
public class ArticleRestControllerTest2 {

    @Resource
    private MockMvc mockMvc;

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
                // ���������application.yml�����⵼��ʱ���ʽ��������ȱ��Spring����������ǰ������ע��
                "    \"reader\" : [{\"name\":\"zimug\",\"age\":18},{\"name\":\"kobe\",\"age\":37}]\n" +
                "}";

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders
                        .request(HttpMethod.POST, "/rest/articles")
                        .contentType("application/json")
                        .content(article)
        )
                // ����ֵ�������ڶ���assert
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.author").value("zimug"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.reader[0].age").value(18))
                .andDo(print())
                .andReturn();

        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        log.info(mvcResult.getResponse().getContentAsString());
    }
}
