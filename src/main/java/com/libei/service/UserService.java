package com.libei.service;

import com.libei.controller.request.RegisteredRequest;
import com.libei.entity.UserEntity;

public interface UserService {
    UserEntity query(String account);

    Boolean registered(RegisteredRequest Request);
}
