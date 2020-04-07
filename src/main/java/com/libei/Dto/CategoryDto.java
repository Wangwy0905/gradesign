package com.libei.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class CategoryDto {
    private Long id;
    private String categoryName;
    private Long firstId;
    private Long type;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
}
