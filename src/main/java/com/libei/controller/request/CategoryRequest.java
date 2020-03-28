package com.libei.controller.request;

import lombok.Data;

import java.util.Date;

@Data
public class CategoryRequest {
    private String categoryName;
    private Long firstId;
    private Long type;
    private Date createTime;
}
