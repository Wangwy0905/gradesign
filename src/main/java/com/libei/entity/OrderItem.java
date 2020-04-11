package com.libei.entity;

import lombok.Data;

import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Table(name = "order_detail")
public class OrderItem {
    private Long id;
    private String orderId;
    private Long productId;
    private Double cost;
    private Integer count;
    private Long userId;
    private LocalDateTime createDate;
}
