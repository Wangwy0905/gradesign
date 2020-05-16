package com.libei.Dto;

import lombok.Data;

@Data
public class ProductDetailDto {
    private Long id;
    private Long CollectId;
    private String productName;
    private String color;   //颜色
    private Double price;  //价格
    //private Integer hot;
    private Integer repertory;//库存
    private String picture;   //图片
    private String capacity;   //容量
    //private String saleCount;  //销售量  待添加
    private String brand;
    private String description;
    private Long categoryId;
    private Long categoryId2;
    private Long createTime;
    private Boolean status;
    private Integer saleCount;
}
