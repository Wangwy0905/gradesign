package com.libei.service;

import com.libei.controller.request.LoginRequest;
import com.libei.controller.request.RegisteredRequest;

public interface LoginService {

    Boolean login(LoginRequest request) throws Exception;

    Boolean registered(RegisteredRequest request) throws Exception;
}
