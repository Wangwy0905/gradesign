package com.libei.mapper;


import com.libei.entity.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<UserEntity> {


    List<UserEntity> queryUser(@Param("name") String name, @Param("phoneNum") String phoneNum);

    UserEntity query(@Param("account") String account);
}
