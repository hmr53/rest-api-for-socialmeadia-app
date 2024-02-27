package com.hasith.restfulwebservicesforsocialmediaapplication.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.MethodArgumentNotValidException;

class CustomErrorMessageBody {
    private Integer count = 0;
    private String message = null;
    private  MethodArgumentNotValidException ex = null;

    public CustomErrorMessageBody(MethodArgumentNotValidException ex) {
        this.count = ex.getErrorCount();
        this.message = ex.getFieldError().getDefaultMessage();
        this.ex = ex;
    }

    public CustomErrorMessageBody(Integer count, String message, Exception ex) {
        this.count = count;
        this.message = message;

    }

    public Integer getCount() {
        return count;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        }catch (JsonProcessingException e){
            return "Error count is :" + ex.getErrorCount()  + " And first Error is "  + ex.getFieldError().getDefaultMessage();
        }

    }
}