package com.libei.service.impl;

import com.libei.Dto.AdminDto;
import com.libei.controller.LoginController.request.LoginRequest;
import com.libei.entity.Admin;
import com.libei.mapper.AdminMapper;
import com.libei.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
   @Autowired
    AdminMapper adminMapper;
    @Override
    public AdminDto queryAdminDto(int page,int rows) {

        List<Admin> admins = adminMapper.queryAll(page,rows);


        Integer integer = adminMapper.totalNum();
        AdminDto adminDto=new AdminDto();
        System.out.println(integer+"111111");
        adminDto.setTotal(integer);
        adminDto.setRows(admins);

        return adminDto;


    }

    @Override
    public Boolean login(LoginRequest request) {
        return null;
    }

    @Override
    public Boolean updatePassword(String password) {
        return null;
    }
}
