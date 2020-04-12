package com.libei.Dto;

import lombok.Data;

import java.util.List;

@Data
public class ShopCarSum {
    private List<ShopCarDto> list;
    private Double totalPrice;
    private Integer count;
}
