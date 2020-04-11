package com.libei.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class BannerFrontDto {
    private Long id;
    private String picture;
    private String title;
    private LocalDateTime createTime;
    private Integer status;
}
