package org.twj.component.testing;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:spring-app.xml"})
@WebAppConfiguration
@DataJpaTest
public abstract class BaseTest {

}
