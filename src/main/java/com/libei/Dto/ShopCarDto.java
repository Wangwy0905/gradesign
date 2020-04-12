package com.libei.Dto;

import lombok.Data;

@Data
public class ShopCarDto {
    private Long id;
    private Integer count; //数量
    private Double price; //价格
    private String productName;
    private String picture;
    private String description;
}
