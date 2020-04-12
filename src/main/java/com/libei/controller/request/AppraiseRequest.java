package com.libei.controller.request;

import lombok.Data;

@Data
public class AppraiseRequest {
    private Long userId;
    private Long productId;
    private String content;
}
