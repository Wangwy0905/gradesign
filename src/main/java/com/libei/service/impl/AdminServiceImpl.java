package com.libei.service.impl;

import com.libei.Dto.AdminDetailDto;
import com.libei.Dto.AdminDto;
import com.libei.controller.request.CommonRequest;
import com.libei.controller.request.LoginRequest;
import com.libei.entity.AdminEntity;
import com.libei.mapper.AdminMapper;
import com.libei.service.AdminService;
import com.libei.util.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public AdminDto queryAdminDto(@RequestBody CommonRequest commonRequest) {

        int pageNum = commonRequest.getPageNum();
        int pageSize = commonRequest.getPageSize();
        List<AdminEntity> adminEntities = adminMapper.queryAll(pageNum, pageSize);
        Integer integer = adminMapper.totalNum();

        AdminDto adminDto = new AdminDto();
        adminDto.setTotal(integer);
        adminDto.setRows(ListUtils.entityListToModelList(adminEntities, AdminDetailDto.class));

        return adminDto;


    }

    @Override
    public Long login(LoginRequest request) throws Exception {
        String account = request.getAccount();
        String password = request.getPassword();


        AdminEntity entity = new AdminEntity();
        entity.setAccount(account);

        AdminEntity adminEntity = adminMapper.selectOne(entity);

        if (adminEntity == null) {
            throw new Exception("账户号不存在,请确定账户号的正确性");
        }

        if (!password.equals(adminEntity.getPassword())) {
            throw new Exception("密码输入错误，请重新输入");
        }

        return adminEntity.getId();
    }

    @Override
    public Boolean updatePassword(Long adminId,String oldPassword, String newPassword, String new2Password) throws Exception {
        AdminEntity adminEntity = adminMapper.selectByPrimaryKey(adminId);

        if (adminEntity == null) {
            throw new Exception("账户信息不存在，请联系管理员");
        }
        String password = adminEntity.getPassword();

        if (!oldPassword .equals(password)) {
            throw new Exception("原密码错误，请重试");
        }

        if (!newPassword.equals(new2Password)) {
            throw new Exception("两次新密码输入不一致，请重试");
        }

        if (newPassword.equals(oldPassword )) {
            throw new Exception("新老密码不能一致，请重新设置");
        }
        adminEntity.setPassword(newPassword);

        adminMapper.updateByPrimaryKey(adminEntity);

        return true;
    }

    @Override
    public List<AdminEntity> queryLike(String param) {
        List<AdminEntity> adminEntities = adminMapper.queryLike(param);
        return  adminEntities;
    }
}
