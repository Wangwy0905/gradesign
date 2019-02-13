package com.wenyi.Dto;

import com.wenyi.entity.Computer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComputerDto {
    private  Integer total;
    private List<Computer> rows;
}
