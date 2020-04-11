package com.libei.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class OrderDto {

    private Long id;
    private String orderId;
    private Double cost;
    private Integer number;
    private Long userId;
    private Long addressId;
    private String status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createDate;
    private String account;
    private String detailAddress;
}
