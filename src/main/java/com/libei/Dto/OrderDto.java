package com.libei.Dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderDto {

    private Long id;
    private String orderId;
    private Double cost;
    private Integer number;
    private Long userId;
    private Long addressId;
    private String status;
    private LocalDateTime createDate;
    private String account;
    private String detailAddress;
}
