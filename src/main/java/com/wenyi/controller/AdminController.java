package com.wenyi.controller;

import com.wenyi.Dto.AdminDto;
import com.wenyi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @RequestMapping("queryAdminDto")
    public AdminDto queryAdminDto(int page,int rows){
        AdminDto adminDto = adminService.queryAdminDto(page,rows);

        return adminDto;

    }

    //登录


}
