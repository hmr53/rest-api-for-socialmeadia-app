package com.hasith.restfulwebservicesforsocialmediaapplication.hello;

import org.aspectj.bridge.Message;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloController {

    private MessageSource messageSource;

    public HelloController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping(path = "/hello")
    public String hello(){
        Locale locale = LocaleContextHolder.getLocale();
        System.out.println(locale);
        return messageSource.getMessage("good.morning.message",null,"Default message",locale);
//        return "Hello";
    }
}
