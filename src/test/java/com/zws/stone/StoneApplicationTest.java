package com.zws.stone;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * @Author wensh.zhu
 * @Date 2019/3/20 17:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StoneApplicationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void exampleTest() throws Exception {
        this.mvc.perform(get("/aaa")).andExpect(status().isOk())
                .andExpect(content().string("Hello World"));
    }

}
