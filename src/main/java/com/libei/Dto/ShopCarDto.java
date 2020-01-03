package com.libei.Dto;

import com.libei.entity.ProductEntity;
import lombok.Data;

import java.util.Map;

@Data
public class ShopCarDto {
    private Map<ProductEntity, Double> productHashMap;
    private Double totalNum;
}
