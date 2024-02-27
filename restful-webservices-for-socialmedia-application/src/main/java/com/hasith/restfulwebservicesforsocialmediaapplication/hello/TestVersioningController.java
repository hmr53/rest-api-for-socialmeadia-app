package com.hasith.restfulwebservicesforsocialmediaapplication.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestVersioningController {

//    @GetMapping("/v1/person")
//    public PersonV1 sendPersonV1(){
//        return new PersonV1("Hasith Malshan");
//    }
//
//    @GetMapping("/v2/person")
//    public PersonV2 sendPersonV2(){
//        return new PersonV2("Hasith","Malshan");
//    }
//
//    @GetMapping(value = "/person", params = "version=1")
//    public PersonV1 sendPersonV1Param(){
//        return new PersonV1("Hasith Malshan");
//    }
//
//    @GetMapping(value = "/person",params = "version=2")
//    public PersonV2 sendPersonV2Param(){
//        return new PersonV2("Hasith","Malshan");
//    }

//    @GetMapping(value = "/person", headers = "X-API-VERSION=1")
//    public PersonV1 sendPersonV1Param(){
//        return new PersonV1("Hasith Malshan");
//    }
//
//    @GetMapping(value = "/person",headers = "X-API-VERSION=2")
//    public PersonV2 sendPersonV2Param(){
//        return new PersonV2("Hasith","Malshan");
//    }

    @GetMapping(value = "/person", produces = "application/com.hmr.v1+json")
    public PersonV1 sendPersonV1Param(){
        return new PersonV1("Hasith Malshan");
    }

    @GetMapping(value = "/person",produces = "application/com.hmr.v2+json")
    public PersonV2 sendPersonV2Param(){
        return new PersonV2("Hasith","Malshan");
    }
}
