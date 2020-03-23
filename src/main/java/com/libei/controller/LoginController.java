package com.libei.controller;

import com.libei.controller.request.LoginRequest;
import com.libei.controller.request.RegisteredRequest;
import com.libei.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author li bei
 * @description 登录相关接口
 * @date 2019.12.31
 */
@RestController
@RequestMapping("login")
public class LoginController {
    @Autowired
    LoginService loginService;

    @CrossOrigin
    @PostMapping("login")
    public Boolean login(@RequestBody LoginRequest request) throws Exception {

        return loginService.login(request);
    }

    @CrossOrigin
    @PostMapping("registered")
    public Boolean registered(@RequestBody RegisteredRequest request) throws Exception {

        return loginService.registered(request);
    }

}
