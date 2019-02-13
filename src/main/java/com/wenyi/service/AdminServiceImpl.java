package com.wenyi.service;

import com.wenyi.Dto.AdminDto;
import com.wenyi.entity.Admin;
import com.wenyi.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements  AdminService {
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
}
