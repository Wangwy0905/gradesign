package com.libei.service.impl;

import com.libei.entity.UserEntity;
import com.libei.mapper.UserMapper;
import com.libei.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserEntity query(String account) {
        return userMapper.selectOneByExample(account);
    }

    @Override
    public Boolean query(String account, String password) {
        if (userMapper.query(account, password) == null) {
            return false;
        }
        return true;
    }
}
