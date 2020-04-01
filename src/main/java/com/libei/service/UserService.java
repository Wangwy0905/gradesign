package com.libei.service;

import com.libei.controller.request.CommonRequest;
import com.libei.controller.request.RegisteredRequest;
import com.libei.entity.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity query(String account);

    Boolean registered(RegisteredRequest Request) throws Exception;

    //用户查询
    List<UserEntity> query();

    Boolean delete(Long id) throws Exception;

    List<UserEntity> search(CommonRequest commonRequest);
}
