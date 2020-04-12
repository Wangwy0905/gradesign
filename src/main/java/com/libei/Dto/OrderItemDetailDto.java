package com.libei.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.libei.entity.ProductEntity;
import lombok.Data;

import java.time.LocalDateTime;

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
}
