package org.twj.component.testing.services;

import org.springframework.stereotype.Component;

@Component
public class HelloWorldService {
    public String sayHello() {
        return "Hello Spring Application";
    }
}
