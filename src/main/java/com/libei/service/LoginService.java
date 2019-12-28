package com.libei.service;

import com.libei.controller.LoginController.request.LoginRequest;

public interface LoginService {

    Boolean login(LoginRequest request);

    Boolean registered(LoginRequest request);
}
