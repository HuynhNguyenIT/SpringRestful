package com.huynh.restfulwebservices.helloworld;

import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@Slf4j
public class HelloWorldController {
    //    @Autowired
    private MessageSource messageSource;
//    private Locale locale;
    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
//        locale = LocaleContextHolder.getLocale();
//        log.info(locale.getCountry());
    }
    @GetMapping(path = "/hello-world")
    public String hello() {
        return "Hello1";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloBean() {
        return new HelloWorldBean("HelloWorldBean1");
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloBean(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello %s", name));
    }

    @GetMapping(path = "/hello-world-i18n")
    public String helloI18N() {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
    }

}
