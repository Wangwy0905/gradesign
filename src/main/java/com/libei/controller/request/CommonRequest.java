package com.libei.controller.request;

import lombok.Data;

@Data
public class CommonRequest {
    private int pageNum;
    private int pageSize;
    private String name;
    private String phoneNum;
}
