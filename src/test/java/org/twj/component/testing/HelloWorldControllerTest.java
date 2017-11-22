package org.twj.component.testing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:spring-app.xml"})
@WebAppConfiguration
public class HelloWorldControllerTest {

    @Test
    public void should_pass(){
        assertTrue(true);
    }

    @Autowired
    private HelloWorldController controller;


    @Test
    public void controller_should_not_be_null(){
        assertThat(controller).isNotNull();
    }
}
