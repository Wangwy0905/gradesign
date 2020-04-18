package com.libei.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

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
    @Column(name = "address")
    private String address;
    @Column(name = "create_date")
    private Long createDate;
}
