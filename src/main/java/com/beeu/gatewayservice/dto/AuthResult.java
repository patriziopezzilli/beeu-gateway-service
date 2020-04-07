package com.beeu.gatewayservice.dto;

import java.io.Serializable;

public class AuthResult implements Serializable {

    private Integer code;
    private String result;

    public AuthResult(Integer code, String result) {
        this.code = code;
        this.result = result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
