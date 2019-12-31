package com.libei.controller.request;

import lombok.Data;

@Data
public class RegisteredRequest {
    private String account;
    private String password;
    private String idNum;
    private Boolean sex;
    private String email;
}
