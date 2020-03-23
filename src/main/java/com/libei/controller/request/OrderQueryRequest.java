package com.libei.controller.request;

import lombok.Data;

@Data
public class OrderQueryRequest {
    private Integer pageSize;
    private Integer pageNum;
}
