package com.libei.Dto;

import com.libei.entity.PhoneEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComputerDto {
    private  Integer total;
    private List<PhoneEntity> rows;
}
