package com.libei.entity;

import lombok.Data;

@Data
public class OrderItem {
    private Long id;
    private String orderId;
    private Long productId;
    private Double cost;
    private Integer quesntity;
}
