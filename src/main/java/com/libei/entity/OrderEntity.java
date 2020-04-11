package com.libei.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Table(name = "order_entity")
public class OrderEntity {
    @Id
    @Column(name = "id")
    private Long id;
    private String orderId; //uuid
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
    @Column(name = "create_date")
    private LocalDateTime createDate;
}
