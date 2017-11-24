package org.twj.component.testing;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MockedResponse implements ClientHttpResponse {
    private String bodyContent;

    public MockedResponse(String bodyContent) {
        this.bodyContent = bodyContent;
    }

    @Override
    public HttpStatus getStatusCode() throws IOException {
        return HttpStatus.OK;
    }

    @Override
    public int getRawStatusCode() throws IOException {
        return 200;
    }

    @Override
    public String getStatusText() throws IOException {
        return "OK";
    }

    @Override
    public void close() {

    }

    @Override
    public InputStream getBody() throws IOException {
        byte[] bytes = bodyContent.getBytes("UTF8");
        return new ByteArrayInputStream(bytes);
    }

    @Override
    public HttpHeaders getHeaders() {
        return new HttpHeaders();
    }
}
