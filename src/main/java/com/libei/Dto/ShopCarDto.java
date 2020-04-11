package com.libei.Dto;

import lombok.Data;

@Data
public class ShopCarDto {
    private Long id;
    private Integer count;
    private Double price;
    private String productName;
    private String picture;
    private String description;
}
