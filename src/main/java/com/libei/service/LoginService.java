package com.libei.service;

import com.libei.controller.request.LoginRequest;
import com.libei.controller.request.RegisteredRequest;
import com.libei.entity.UserEntity;

public interface LoginService {

    UserEntity login(LoginRequest request) throws Exception;

    Boolean registered(RegisteredRequest request) throws Exception;
}
