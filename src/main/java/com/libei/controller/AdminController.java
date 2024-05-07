package com.libei.controller;

import com.libei.Dto.AdminDto;
import com.libei.controller.request.CommonRequest;
import com.libei.controller.request.LoginRequest;
import com.libei.entity.AdminEntity;
import com.libei.entity.UserEntity;
import com.libei.service.AdminService;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public Boolean update(@RequestParam("adminId") Long adminId, @RequestParam("oldPassword") String oldPassword, @RequestParam("newPassword") String newPassword, @RequestParam("new2Password") String new2Password) throws Exception {

        return adminService.updatePassword(adminId, oldPassword, newPassword, new2Password);

    }

    public static void main(String[] args) {

        String str = "\\wangwenyi";
        String s = str.replaceFirst("\\\\", "\\\\5c");

        System.out.println(s);

//        List<UserEntity> list = new ArrayList<>();
//        List<UserEntity> list2 = new ArrayList<>();
//        UserEntity userEntity = new UserEntity();
//        userEntity.setName("");
//        userEntity.setEmail("1458930487@qq.com");
//        list.add(userEntity);
//
//
//        userEntity = new UserEntity();
//        userEntity.setName("2");
//        userEntity.setEmail("14589");
//        list.add(userEntity);
//
//        userEntity = new UserEntity();
//        userEntity.setName("3");
//        userEntity.setEmail("1492");
//        list.add(userEntity);
//
//
//        userEntity = new UserEntity();
//        userEntity.setName("2");
//        userEntity.setEmail("14589");
//        list2.add(userEntity);
//
//        list.addAll(list2);
//
//        //List<UserEntity> collect = list.stream().sorted(Comparator.nullsFirst(Comparator.comparing(UserEntity::getAccount))).collect(Collectors.toList());
//        System.out.println(list);
//        list.stream().filter(UserEntity -> "".equals(UserEntity.getName())).forEach(UserEntity -> UserEntity.setName(null));
//        System.out.println(list);
//        List<UserEntity> sortedList = list.stream().distinct().sorted(Comparator.comparing(UserEntity::getName, Comparator.nullsLast(Comparator.reverseOrder()))).collect(Collectors.toList());
//
//        System.out.println(sortedList);
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
