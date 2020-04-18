package com.libei.controller.request;

import lombok.Data;

import java.util.Date;

@Data
public class CategoryRequest {
    private Long id;
    private String categoryName;
    private Long firstId;
}
