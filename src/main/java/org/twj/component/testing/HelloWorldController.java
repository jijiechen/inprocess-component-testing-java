package org.twj.component.testing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.twj.component.testing.services.HelloWorldService;

@Controller
public class HelloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "text/plain")
    @ResponseBody
    public String index() {
        return helloWorldService.sayHello();
    }
}
