package com.libei.service;

import com.libei.entity.UserEntity;

public interface UserService {
    UserEntity query(String account);

    Boolean query(String account, String password);
}
