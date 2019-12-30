package com.libei.service;

import com.libei.controller.request.LoginRequest;

public interface LoginService {

    Boolean login(LoginRequest request) throws Exception;

    Boolean registered(LoginRequest request);
}
