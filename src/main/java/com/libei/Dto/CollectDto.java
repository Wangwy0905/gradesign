package com.libei.Dto;

import lombok.Data;

import java.util.Date;

@Data
public class CollectDto {
    private Long id;
    private Long userId;
    private Long productId;
    private Date createDate;
}
