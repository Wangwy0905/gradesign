package com.libei.service.impl;

import com.libei.controller.request.CommonRequest;
import com.libei.controller.request.RegisteredRequest;
import com.libei.controller.request.UserRequest;
import com.libei.entity.UserEntity;
import com.libei.mapper.AddressMapper;
import com.libei.mapper.AppraiseMapper;
import com.libei.mapper.OrderMapper;
import com.libei.mapper.UserMapper;
import com.libei.service.UserService;
import com.libei.util.RandomSaltUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

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
        userEntity.setCreateTime(System.currentTimeMillis());

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

    @Override
    public Boolean update(UserRequest request) throws Exception {

        UserEntity entity = userMapper.selectByPrimaryKey(request.getUserId());

        if (entity == null) {
            throw new Exception("账户信息不存在，请联系管理员");
        }

        BeanUtils.copyProperties(request, entity);

        System.out.println(entity);

        userMapper.updateByPrimaryKey(entity);

        return true;
    }

    @Override
    public UserEntity queryUser(Long userId) throws Exception {
        UserEntity userEntity = userMapper.selectByPrimaryKey(userId);
        if (userEntity == null) {
            throw new Exception("账户信息不存在，请联系管理员");
        }
        return userEntity;
    }

    @Override
    public Boolean updatePassword(Long userId, String oldPassword, String newPassword, String new2Password) throws Exception {
        UserEntity userEntity = userMapper.selectByPrimaryKey(userId);
        if (userEntity == null) {
            throw new Exception("账户信息不存在，请联系管理员");
        }
        String password = userEntity.getPassword();
        String salt = userEntity.getSalt();

        if (!DigestUtils.md5DigestAsHex((oldPassword + salt).getBytes()).equals(password)) {
            throw new Exception("原密码错误，请重试");
        }

        if (!newPassword.equals(new2Password)) {
            throw new Exception("两次新密码输入不一致，请重试");
        }

        if (DigestUtils.md5DigestAsHex((newPassword + salt).getBytes()).equals(DigestUtils.md5DigestAsHex((oldPassword + salt).getBytes()))) {
            throw new Exception("新老密码不能一致，请重新设置");
        }
        userEntity.setPassword(DigestUtils.md5DigestAsHex((newPassword + salt).getBytes()));

        userMapper.updateByPrimaryKey(userEntity);

        return true;
    }

//    public static void main(String[] args) {
//        String s = DigestUtils.md5DigestAsHex(("123456" + "2W32").getBytes());
//        System.out.println(s);
//    }
}
