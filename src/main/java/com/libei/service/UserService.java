package com.libei.service;

import com.github.pagehelper.PageInfo;
import com.libei.controller.request.CommonRequest;
import com.libei.controller.request.RegisteredRequest;
import com.libei.entity.UserEntity;

public interface UserService {
    UserEntity query(String account);

    Boolean registered(RegisteredRequest Request);

    PageInfo query(CommonRequest request);

    Boolean delete(Long id) throws Exception;
}
