package com.libei.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.libei.controller.request.CommonRequest;
import com.libei.controller.request.RegisteredRequest;
import com.libei.entity.UserEntity;
import com.libei.mapper.*;
import com.libei.service.UserService;
import com.libei.util.RandomSaltUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private AppraiseMapper appraiseMapper;
//    @Autowired
//    private

    @Override
    public UserEntity query(String account) {
        UserEntity entity = new UserEntity();
        entity.setAccount(account);
        return userMapper.selectOne(entity);
    }

    @Override
    public Boolean registered(RegisteredRequest request) throws Exception {

        UserEntity userEntity = new UserEntity();
        //校验数据库是否已有该账户
        userEntity.setAccount(request.getAccount());
        UserEntity entity = userMapper.selectOne(userEntity);
        if (entity != null) {
            throw new Exception("该账户已存在，请换账号登录");
        }

        BeanUtils.copyProperties(request, userEntity);
        userEntity.setStatus("1");

        String salt = RandomSaltUtils.generetRandomSaltCode();
        userEntity.setPassword(DigestUtils.md5DigestAsHex((userEntity.getPassword() + salt).getBytes()));
        userEntity.setSalt(salt);
        userEntity.setCreateTime(new Date());

        userMapper.insert(userEntity);

        return true;
    }

    @Override
    public List<UserEntity> query() {

        List<UserEntity> userEntityList = userMapper.selectAll();

        return userEntityList;
    }

    @Override
    @Transactional
    public Boolean delete(Long id) throws Exception {
        UserEntity userEntity = userMapper.selectByPrimaryKey(id);

        if (userEntity == null) throw new Exception("该用户不存在，请确认数据正确性");

        userMapper.deleteByPrimaryKey(id);
        orderMapper.deleteByUserId(id);
        addressMapper.deleteByUserId(id);
        appraiseMapper.deleteByUserId(id);

        return true;
    }

    //搜索
    @Override
    public List<UserEntity> search(CommonRequest commonRequest) {

        String name = commonRequest.getName();
        String phoneNum = commonRequest.getPhoneNum();

        return userMapper.queryUser(name, phoneNum);
    }

}
