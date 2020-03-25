package com.libei.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.libei.enums.BlandEnum;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.Date;

@Data
public class ProductDetailDto {
    private Long id;
    private String productName;
    private String color;   //颜色
    private Double price;  //价格
    //private Integer hot;
    private Integer repertory;//库存
    private String picture;   //图片
    private String capacity;   //容量
    //private String saleCount;  //销售量  待添加
    private BlandEnum brand;
    private String description;
    private Long categoryId;
    private Long categoryId2;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    private Boolean status;
}
