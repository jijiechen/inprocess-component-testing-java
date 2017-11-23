package org.twj.component.testing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.twj.component.testing.models.ColorData;
import org.twj.component.testing.services.HttpInvoker;

import java.io.IOException;


@Controller
public class HttpDependencyController {


    @Autowired
    private HttpInvoker httpInvoker;

    @RequestMapping(value = "/http-dependency", method = RequestMethod.GET)
    public ColorData getColor() throws IOException {
        ClientHttpResponse response = httpInvoker.requestHttpResource("http://adobe.github.io/Spry/data/json/object-01.js");

        String body = IOUtils.toString(response.getBody(), "UTF-8");

        ColorData color = new Gson().fromJson(body, ColorData.class);
        return color;
    }
}
