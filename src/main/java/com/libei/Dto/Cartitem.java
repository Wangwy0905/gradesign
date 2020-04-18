package com.libei.Dto;

import com.libei.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cartitem {
    private ProductEntity entity;
    private Integer count;
    private Double price;//小计
   // private Integer ddPrice;
}
