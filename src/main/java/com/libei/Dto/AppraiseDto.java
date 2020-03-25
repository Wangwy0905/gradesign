package com.libei.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class AppraiseDto {
    private Long id;
    private Long userId;
    private Long orderId;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;
}
