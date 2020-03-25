package com.libei.Dto;

import lombok.Data;

import java.util.List;

@Data
public class AddressResDto {
    //总行数
    private  Integer total;
    //当前页的数据行
    private List<AddressDto> rows;
}
