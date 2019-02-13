package com.wenyi.service;

import com.wenyi.Dto.ComputerDto;
import com.wenyi.entity.Computer;
import com.wenyi.mapper.ComputerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ComputerServiceImpl implements  ComputerService {
    @Autowired
    ComputerMapper computerMapper;
    @Override
    public ComputerDto queryAll(int id,int page,int rows) {
        List<Computer> computers = computerMapper.queryAll(id,page,rows);
        Integer integer = computerMapper.totalNum();
        ComputerDto computerDto=new ComputerDto();
        computerDto.setRows(computers);
        computerDto.setTotal(integer);
        return computerDto;
    }
}
