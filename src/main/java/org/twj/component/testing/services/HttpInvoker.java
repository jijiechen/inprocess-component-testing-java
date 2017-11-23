package org.twj.component.testing.services;

import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.net.MalformedURLException;

public interface HttpInvoker {
    ClientHttpResponse requestHttpResource(String url) throws IOException;
}
