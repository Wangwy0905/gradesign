package com.libei.controller.LoginController;

import com.libei.controller.LoginController.request.LoginRequest;
import com.libei.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login")
public class LoginController {
    @Autowired
    LoginService loginService;

    @CrossOrigin
    @PostMapping("login")
    public Boolean login(@RequestBody LoginRequest request) {

        return loginService.login(request);
    }

    @CrossOrigin
    @PostMapping("registered")
    public Boolean registered(@RequestBody LoginRequest request) {

        return loginService.registered(request);
    }

}
