package com.libei.Dto;

import lombok.Data;

import java.util.List;

@Data
public class CollectResDto {
    private Integer total;
    private List<CollectDto> rows;
}
