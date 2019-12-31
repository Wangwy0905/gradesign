package com.libei.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.libei.enums.BlandEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class ProductEntity {
    @Id
    private Long id;
    private String productName;
    private String color;   //颜色
    private Double price;  //价格
    //private Integer hot;
    private Integer repertory;//库存
    private String picture;   //图片
    private String capacity;   //容量
    private String weight;     //重量
    @Enumerated(EnumType.STRING)
    private BlandEnum brand;
    private String description;
    private Long categoryId;
    private Long categoryId2;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date createTime;
    private Boolean status;

}