package com.libei.Dto;

import lombok.Data;

import java.util.List;

@Data
public class AppraiseResDto {
    private Integer total;
    private List<AppraiseDto> rows;
}
