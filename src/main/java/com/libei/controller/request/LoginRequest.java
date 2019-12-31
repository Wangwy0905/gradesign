package com.libei.controller.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String account;
    private String password;
    private String type;  //0-管理员  1-用户
}
