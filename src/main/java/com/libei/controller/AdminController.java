package com.libei.controller;

import com.libei.Dto.AdminDto;
import com.libei.controller.request.AdminRequest;
import com.libei.controller.request.CommonRequest;
import com.libei.controller.request.LoginRequest;
import com.libei.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @CrossOrigin
    @PostMapping("queryAll")
    public AdminDto queryAll(@RequestBody CommonRequest commonRequest) throws Exception {
        return adminService.queryAdminDto(commonRequest);

    }


    @CrossOrigin
    @PostMapping("update-password")
    public Boolean update(@RequestBody AdminRequest adminRequest) throws Exception {
        return adminService.updatePassword(adminRequest);

    }

    @CrossOrigin
    @PostMapping("login")
    public Boolean login(@RequestBody LoginRequest loginRequest) throws Exception {
        return adminService.login(loginRequest);

    }

    //添加接口  待写
}