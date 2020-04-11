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
import java.time.LocalDateTime;
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
    //private String saleCount;  //销售量  待添加
    private String brand;
    private String description;
    private Long categoryId;
    private Long categoryId2;
    private LocalDateTime createTime;
    private Boolean status;

}
