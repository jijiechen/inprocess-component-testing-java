package org.twj.component.testing;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class HelloWorldControllerIntTest extends BaseTest {

    @Autowired
    private HelloWorldController controller;

    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void givenHomePageURI_whenMockMVC_thenReturnsIndexContent() throws Exception {
        ResultActions result = this.mockMvc.perform(get("/"));

        result.andExpect(status().isOk())
              .andExpect(content().string("Hello Spring Application"));

    }
}
