package com.libei.Dto;

import lombok.Data;

@Data
public class PaySuccessDto {
    private String orderId;
    private String gainName;
    private String phoneNum;
    private String detailAddress;
    private Double totalPrice;
}
