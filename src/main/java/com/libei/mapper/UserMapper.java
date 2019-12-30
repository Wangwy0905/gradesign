package com.libei.mapper;


import com.libei.entity.UserEntity;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<UserEntity> {

    UserEntity query(String account, String password);
}
