package com.libei.service.impl;

import com.libei.Dto.ComputerDto;
import com.libei.controller.backController.request.PhoneCommitRequest;
import com.libei.controller.backController.request.PhoneQueryRequest;
import com.libei.entity.PhoneEntity;
import com.libei.mapper.ComputerMapper;
import com.libei.service.PhoneService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PhoneServiceImpl implements PhoneService {
    @Autowired
    ComputerMapper computerMapper;

    @Override
    public ComputerDto queryAll(Integer pageNum, Integer pageSize) {
        List<PhoneEntity> computers = computerMapper.queryAll(pageNum,pageSize);
        Integer integer = computerMapper.totalNum();
        ComputerDto computerDto=new ComputerDto();
        computerDto.setRows(computers);
        computerDto.setTotal(integer);
        return computerDto;
    }

    @Override
    public Boolean addPhone(PhoneCommitRequest request) {
        return null;
    }


    @Override
    public Boolean delete(Integer id) {
        return null;
    }

    @Override
    public Boolean update(PhoneCommitRequest request) {
        return null;
    }

    @Override
    public Boolean queryOne(PhoneQueryRequest request) {
        return null;
    }
}
