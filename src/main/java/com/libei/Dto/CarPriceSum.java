package com.libei.Dto;

import lombok.Data;

import java.util.Map;

@Data
public class CarPriceSum {
    private Map<Long,Cartitem> map;
    private Double totalPrice;
}
