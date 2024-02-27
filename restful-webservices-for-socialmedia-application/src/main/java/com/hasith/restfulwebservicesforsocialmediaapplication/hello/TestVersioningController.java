package com.hasith.restfulwebservicesforsocialmediaapplication.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestVersioningController {

    @GetMapping("/v1/person")
    public PersonV1 sendPersonV1(){
        return new PersonV1("Hasith Malshan");
    }

    @GetMapping("/v2/person")
    public PersonV2 sendPersonV2(){
        return new PersonV2("Hasith","Malshan");
    }
}