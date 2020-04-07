package com.libei.controller.request;

import com.libei.enums.BlandEnum;
import lombok.Data;

@Data
public class ProductCommitRequest {
    private Long id;
    private String productName;
    private String color;   //颜色
    private Double price;  //价格
    private Integer repertory;//库存
    private String capacity;   //容量
    private String description;
    private BlandEnum brand; //品牌
    private Long categoryId;
    private Long categoryId2;
}
