package com.libei.controller.request;

import lombok.Data;

@Data
public class UserRequest {
    private Long userId;
    private String account;
    private String name;
    private String idNum;
    private Boolean sex;
    private String email;
}
