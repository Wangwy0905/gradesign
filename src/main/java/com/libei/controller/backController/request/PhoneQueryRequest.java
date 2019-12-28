package com.libei.controller.backController.request;

import lombok.Data;

@Data
public class PhoneQueryRequest {
    private Integer pageSize;
    private Integer pageNum;
    private String param;
}
