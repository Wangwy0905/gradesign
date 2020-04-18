package com.libei.controller;

import com.libei.controller.request.CommonRequest;
import com.libei.controller.request.UserRequest;
import com.libei.entity.UserEntity;
import com.libei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author li bei
 * @date 2020.1.2
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    //用户查询
    @CrossOrigin
    @RequestMapping(value = "query", method = RequestMethod.POST)
    public List<UserEntity> query() {
        return userService.query();

    }

    //用户删除
    @CrossOrigin
    @GetMapping("delete")
    public Boolean delete(@RequestParam @Valid @NotNull Long id) throws Exception {
        return userService.delete(id);

    }

    //搜索
    @CrossOrigin
    @RequestMapping(value = "search", method = RequestMethod.GET)
    public List<UserEntity> search(@RequestParam("account") String account) {
        return userService.search(account);

    }

    @CrossOrigin
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Boolean update(@RequestBody UserRequest request) throws Exception {
        return userService.update(request);

    }

    @CrossOrigin
    @RequestMapping(value = "queryUser", method = RequestMethod.GET)
    public UserEntity queryUser(@RequestParam("userId") Long userId) throws Exception {
        return userService.queryUser(userId);

    }

    @CrossOrigin
    @RequestMapping(value = "updatePassword", method = RequestMethod.GET)
    public Boolean updatePassword(@RequestParam("userId") Long userId,@RequestParam("oldPassword") String oldPassword,@RequestParam("newPassword") String newPassword,@RequestParam("new2Password") String new2Password ) throws Exception {
        return userService.updatePassword(userId,oldPassword,newPassword,new2Password);

    }




}
