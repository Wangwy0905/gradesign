package com.wenyi.service;

import com.wenyi.Dto.ComputerDto;
import com.wenyi.entity.Computer;

import java.util.List;

public interface ComputerService {
    public ComputerDto queryAll(int id,int page,int rows);
}
