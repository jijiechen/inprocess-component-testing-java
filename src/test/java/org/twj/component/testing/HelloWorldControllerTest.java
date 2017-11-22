package org.twj.component.testing;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.ReflectionTestUtils.setField;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:spring-app.xml"})
@WebAppConfiguration
public class HelloWorldControllerTest {

    @Test
    public void should_pass(){
        assertTrue(true);
    }

    @Autowired
    private HelloWorldController helloController;
    @Autowired
    private HelloWorldService helloService;
    @Autowired
    ApplicationContext appContext;


    @Test
    public void controller_should_not_be_null(){
        assertThat(helloController).isNotNull();
    }

    @Test
    public void controller_should_work_as_expected(){
        // HelloWorldController ctrl = appContext.getBean(HelloWorldController.class);

        String helloResult = helloController.index();
        assertEquals("Hello Spring Application" ,helloResult);
    }

    @Test
    public void controller_service_should_be_able_to_be_mocked(){
        HelloWorldService serviceMock = mock(HelloWorldService.class);
        when(serviceMock.sayHello()).thenReturn("Mocked Hello World");

        setField(helloController, "helloWorldService", serviceMock);
        String helloResult = helloController.index();


        assertEquals("Mocked Hello World" ,helloResult);
    }


    @After
    public void restore(){
        setField(helloController, "helloWorldService", helloService);
    }
}
