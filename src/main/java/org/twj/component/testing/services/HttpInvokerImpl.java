package org.twj.component.testing.services;

import org.springframework.http.HttpHeaders;
import org.springframework.http.client.AbstractClientHttpResponse;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class HttpInvokerImpl implements HttpInvoker {
    @Override
    public ClientHttpResponse requestHttpResource(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();

        return new AbstractClientHttpResponse() {

            @Override
            public int getRawStatusCode() throws IOException {
                return connection.getResponseCode();
            }

            @Override
            public String getStatusText() throws IOException {
                return connection.getResponseMessage();
            }

            @Override
            public void close() {
                connection.disconnect();
            }

            @Override
            public InputStream getBody() throws IOException {
                return connection.getInputStream();
            }

            @Override
            public HttpHeaders getHeaders() {
                return new HttpHeaders();
            }
        };

    }
}
