package com.libei.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="phone")
public class PhoneEntity {
    @Id
    private  Integer id;
    @Column(name = "productName")
    private  String productName;
    @Column(name = "color")
    private  String color;
    @Column(name = "price")
    private  Double price;
    @Column(name = "hot")
    private  Integer  hot;
    @Column(name = "repertory")
    private  Integer repertory;//库存
    @Column(name = "picture")
    private  String picture;
    @Column(name = "price")
    private  String description;
    @Column(name = "categoryId")
    private  Integer  categoryId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    @Column(name="createTime")
    private  Date createTime;

//    private String chuliqi;
//    private String neicuntiao;
//    @Column(name = "comPic")
//
//    private Integer status;
}
