package com.aricsun.boot.launch;

import com.aricsun.boot.launch.model.Article;
import com.aricsun.boot.launch.model.Reader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author AricSun
 * @date 2020.12.06 0:29
 */
public class JacksonTest {
    @Test
    void testJackson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        List<Reader> readers = new ArrayList<Reader>(){{  // 实例初始化器
            add(new Reader("kobe", 21));
            add(new Reader("james", 20));
        }};

        Article article = Article.builder()
                .id(2L)
                .author("aricSun")
                .content("路径选择工具：U")
                .createTime(new Date())
                .reader(readers)
                .title("PS基本工具")
                .build();

        // java -> json
        String jsonStr = mapper.writeValueAsString(article);
        System.out.println(jsonStr);

        // json -> java Object
        Article article1 = mapper.readValue("{\"content\":\"路径选择工具：U\",\"title\":\"PS基本工具\",\"createTime\":\"2020/12/06 01:17:45\",\"reader\":[{\"name\":\"kobe\",\"age\":21},{\"name\":\"james\",\"age\":20}],\"author\":\"aricSun\"}",
                Article.class);
        System.out.println(article1);
    }
}
