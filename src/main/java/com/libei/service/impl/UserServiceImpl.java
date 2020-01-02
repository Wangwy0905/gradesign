package com.libei.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.libei.controller.request.CommonRequest;
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

import java.util.List;

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

    @Override
    public PageInfo query(CommonRequest request) {
        int pageNum = request.getPageNum();
        int pageSize = request.getPageSize();
        String name = request.getName();
        String phoneNum = request.getPhoneNum();

        PageHelper.startPage(pageNum, pageSize);
        List<UserEntity> userEntityList = userMapper.queryUser(name, phoneNum);

        return new PageInfo(userEntityList);
    }

    @Override
    public Boolean delete(Long id) throws Exception {
        UserEntity userEntity = userMapper.selectByPrimaryKey(id);

        if (userEntity == null) throw new Exception("该用户不存在，请确认数据正确性");

        userEntity.setStatus("0");

        userMapper.insert(userEntity);

        return true;
    }


}
