package com.libei.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class BannerFrontDto {
    private Long id;
    private String picture;
    private String title;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    private Integer status;
}
