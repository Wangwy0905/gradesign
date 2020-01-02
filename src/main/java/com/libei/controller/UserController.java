package com.libei.controller;

import com.github.pagehelper.PageInfo;
import com.libei.controller.request.CommonRequest;
import com.libei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author  li bei
 * @date  2020.1.2
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("query")
    public PageInfo query(@RequestBody CommonRequest request) {
        PageInfo pageInfo = userService.query(request);

        return pageInfo;
    }

    @CrossOrigin
    @PostMapping("delete")
    public Boolean delete(@RequestBody @Valid @NotNull Long id) throws Exception {
        return userService.delete(id);

    }

    //用户信息   不提供修改操作
}
