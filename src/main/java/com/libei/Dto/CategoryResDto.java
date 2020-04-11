package com.libei.Dto;

import lombok.Data;

import javax.persistence.Column;
import java.util.List;

@Data
public class CategoryResDto {
    private Long id;
    private String brand; //品牌
    private String model;//型号
    private Long createTime;
}
