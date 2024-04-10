package com.libei.controller;

import com.libei.Dto.AdminDto;
import com.libei.controller.request.CommonRequest;
import com.libei.controller.request.LoginRequest;
import com.libei.entity.AdminEntity;
import com.libei.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @CrossOrigin
    @PostMapping("queryAll")
    public AdminDto queryAll(@RequestBody CommonRequest commonRequest) throws Exception {
        System.out.println("123测试");

        System.out.println("想要问问你敢不敢");

        return adminService.queryAdminDto(commonRequest);
    }


    @CrossOrigin
    @GetMapping("update-password")
    public Boolean update(@RequestParam("adminId") Long adminId,@RequestParam("oldPassword") String oldPassword,@RequestParam("newPassword") String newPassword,@RequestParam("new2Password") String new2Password) throws Exception {
        return adminService.updatePassword(adminId,oldPassword,newPassword,new2Password);

    }

    @CrossOrigin
    @PostMapping("login")
    public Long login(@RequestBody LoginRequest loginRequest) throws Exception {
        return adminService.login(loginRequest);

    }

    @CrossOrigin
    @PostMapping("query-like")
    public List<AdminEntity> queryLike(@RequestParam("param") String param) {
        System.out.println("小子，飘了");
        System.out.println("你试试额");
        System.out.println("你好啊");
        System.out.println("1111git");
        System.out.println(11);

        return adminService.queryLike(param);
    }

    //添加接口  待写
}
