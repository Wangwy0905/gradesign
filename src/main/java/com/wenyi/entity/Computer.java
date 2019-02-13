package com.wenyi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="computer")
public class Computer {
    @Id
    private  Integer id;
    private  String productName;
    private  String description;
    private  String color;
    private  Double price;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private  Date createTime;
    private  Integer repertory;
    private  Integer  hot;
    private  Integer  categoryId;
    private  String  chuliqi;
    private  String  neicuntiao;
    private  String comPic;
    private  Integer status;
}
