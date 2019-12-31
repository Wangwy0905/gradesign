package com.libei.service.impl;

import com.libei.controller.request.RegisteredRequest;
import com.libei.entity.UserEntity;
import com.libei.mapper.UserMapper;
import com.libei.service.UserService;
import com.libei.util.RandomSaltUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

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
    public Boolean registered(RegisteredRequest request) {
        UserEntity userEntity = new UserEntity();

        BeanUtils.copyProperties(userEntity, request);
        userEntity.setStatus("1");

        String salt = RandomSaltUtils.generetRandomSaltCode();
        userEntity.setPassword(DigestUtils.md5DigestAsHex((userEntity.getPassword() + salt).getBytes()));
        userEntity.setSalt(salt);

        userMapper.insert(userEntity);

        return true;
    }
}
