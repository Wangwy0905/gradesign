package com.libei.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class OrderDto {

    private Long id;
    private Double cost;
    private Integer number;
    private Long userId;
    private Long addressId;
    private String status;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;
}
