package com.libei.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "order")
public class OrderEntity {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "cost")
    private Double cost;
    @Column(name = "number") //购买数量
    private Integer number;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "address_id")
    private Long addressId;
    @Column(name = "status") //支付状态   0-未支付  1-已支付
    private String status;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_date")
    private Date createDate;
}
