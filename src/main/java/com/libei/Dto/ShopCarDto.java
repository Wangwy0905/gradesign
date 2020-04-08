package com.libei.Dto;

import com.libei.entity.ProductEntity;
import lombok.Data;

import java.util.Map;

@Data
public class ShopCarDto {
    private Map<Long,Cartitem> productHashMap;
    private Double totalPrice;
}
