package com.libei.service.impl;

import com.libei.controller.request.LoginRequest;
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
        String salt = request.getSalt();

        UserEntity entity = userService.query(account);
        if (entity == null) {
            throw new Exception("账户号不存在,请确定账户号的正确性");
        }

        if ("0".equals(request.getType())) {
            if (!salt.toUpperCase().equals(entity.getSalt().toUpperCase())) {
                throw new Exception("验证码检验失败，请重试");
            }
        }

        //MD5加密
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        return userService.query(account, password);
    }

    @Override
    public Boolean registered(LoginRequest request) {
        return true;
    }
}
