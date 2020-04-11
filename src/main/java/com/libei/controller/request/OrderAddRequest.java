package com.libei.controller.request;

import lombok.Data;

@Data
public class OrderAddRequest {
    private Double cost;   //总计
    private Integer number; //商品商量
    private Long userId;
    private Long addressId;
}
