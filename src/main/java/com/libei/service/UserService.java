package com.libei.service;

import com.libei.controller.request.CommonRequest;
import com.libei.controller.request.RegisteredRequest;
import com.libei.controller.request.UserRequest;
import com.libei.entity.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity query(String account);

    Boolean registered(RegisteredRequest Request) throws Exception;

    //用户查询
    List<UserEntity> query();

    Boolean delete(Long id) throws Exception;

    List<UserEntity> search(CommonRequest commonRequest);

    Boolean update(UserRequest request) throws Exception;

    UserEntity queryUser(Long userId) throws Exception;

    Boolean updatePassword(Long userId,String oldPassword, String newPassword, String new2Password) throws Exception;
}
