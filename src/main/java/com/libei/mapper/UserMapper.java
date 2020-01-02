package com.libei.mapper;


import com.libei.entity.UserEntity;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<UserEntity> {

    // UserEntity query(String account, String password);

    List<UserEntity> queryUser(@Param("name") String name, @Param("phoneNum") String phoneNum);
}
