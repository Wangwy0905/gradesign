package com.wenyi.controller;

import com.wenyi.Dto.ComputerDto;
import com.wenyi.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("computer")
public class ComputerController  {
    @Autowired
    ComputerService computerService;

    @RequestMapping("queryAll")
    public ComputerDto queryAll(int cateId,int page,int rows){
        ComputerDto computerDto = computerService.queryAll(cateId, page, rows);
        return computerDto;
    }
}
