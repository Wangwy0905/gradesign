package com.libei.Dto;

import com.libei.entity.BannerEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BannerDto {
    private  Integer total;
    private List<BannerEntity> rows;
}
