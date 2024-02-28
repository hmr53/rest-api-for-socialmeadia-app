package com.hasith.restfulwebservicesforsocialmediaapplication.hello;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonFilter("SomeBeanFilter")
//@JsonIgnoreProperties("value1")
public class SomeBean {

    private final String value1;

//    @JsonIgnore
    private final String value2;
    private final String value3;

    public SomeBean(String vaalue1, String vaalue2, String vaalue3) {
        this.value1 = vaalue1;
        this.value2 = vaalue2;
        this.value3 = vaalue3;
    }

    public String getValue1() {
        return value1;
    }

    public String getValue2() {
        return value2;
    }

    public String getValue3() {
        return value3;
    }
}
