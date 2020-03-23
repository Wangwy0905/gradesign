package com.libei.controller.request;

import lombok.Data;

@Data
public class OrderAddRequest {
    private Double cost;
    private Integer number;
    private Long userId;
    private String address;
    private String status;
}
