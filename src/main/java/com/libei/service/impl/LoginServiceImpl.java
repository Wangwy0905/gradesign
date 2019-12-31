package com.libei.service.impl;

import com.libei.controller.request.LoginRequest;
import com.libei.controller.request.RegisteredRequest;
import com.libei.entity.UserEntity;
import com.libei.service.LoginService;
import com.libei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserService userService = null;

    @Override
    public Boolean login(LoginRequest request) throws Exception {
        String account = request.getAccount();
        String password = request.getPassword();

        UserEntity entity = userService.query(account);
        if (entity == null) {
            throw new Exception("账户号不存在,请确定账户号的正确性");
        }
        //MD5加密
        String salt = entity.getSalt();
        password = DigestUtils.md5DigestAsHex((password + salt).getBytes());

        if (!password.equals(entity.getPassword())) {
            throw new Exception("密码输入错误，请重新输入");
        }

        return true;
    }

    @Override
    public Boolean registered(RegisteredRequest request) {

        return userService.registered(request);
    }
}
