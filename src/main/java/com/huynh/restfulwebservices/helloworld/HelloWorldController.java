package com.huynh.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello-world")
    public String hello(){
        return "Hello1";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloBean(){
        return new HelloWorldBean("HelloWorldBean");
    }
}
