package com.hasith.restfulwebservicesforsocialmediaapplication.hello;

public class PersonV2 {

    private String fname;
    private String lname;

    public PersonV2(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }
}
