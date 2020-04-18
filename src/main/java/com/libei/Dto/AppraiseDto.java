package com.libei.Dto;

import lombok.Data;

@Data
public class AppraiseDto {
    private Long id;
    private String account;
    private Long userId;
    private Long productId;
    private String content;
    private Long createDate;
    private String productName;
}
