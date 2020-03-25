package com.libei.controller.request;

import lombok.Data;

@Data
public class ProductQueryRequest {
    private Integer pageSize;
    private Integer pageNum;
    private Long categoryId;
    private Long categoryId2;
}
