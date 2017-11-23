package org.twj.component.testing;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.twj.component.testing.models.ColorData;
import org.twj.component.testing.services.HttpInvoker;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.ReflectionTestUtils.setField;


public class HttpDependencyControllerTest extends BaseTest {


    @Autowired
    private HttpDependencyController httpDependencyCtrl;


    @Test
    public void should_serve_mocked_http_response() throws IOException {
        String mockedHttpJson = "{\"color\": \"white\",  \"value\": \"#fff\"}";
        HttpInvoker invoker = mock(HttpInvoker.class);
        when(invoker.requestHttpResource(anyString())).thenReturn(new MockedResponse(mockedHttpJson));
        setField(httpDependencyCtrl, "httpInvoker", invoker);

        ColorData colorData = httpDependencyCtrl.getColor();

        assertEquals("white", colorData.color);
        assertEquals("#fff", colorData.value);
    }

}
