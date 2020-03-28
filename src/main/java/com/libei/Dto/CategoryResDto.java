package com.libei.Dto;

import lombok.Data;

import java.util.List;

@Data
public class CategoryResDto {
    private Integer total;
    private List<CategoryDto> rows;
}
