package com.libei.Dto;

import com.libei.entity.ProductEntity;
import lombok.Data;

@Data
public class OrderItemDetailDto {
    private Long id;
    private String orderId;
    private Long productId;
    private Double cost;
    private Integer count;
    private Long userId;
    private Long createDate;
    private ProductEntity entity;
    private String productName;
    private String account;
}
