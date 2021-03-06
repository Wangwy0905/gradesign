package com.libei.Dto;

import com.libei.entity.AdminEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDto {
    //总行数
    private  Integer total;
    //当前页的数据行
    private List<AdminDetailDto> rows;
}
