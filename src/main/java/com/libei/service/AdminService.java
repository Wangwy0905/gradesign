package com.libei.service;

import com.libei.Dto.AdminDto;
import com.libei.controller.request.CommonRequest;
import com.libei.controller.request.LoginRequest;
import com.libei.entity.AdminEntity;

import java.util.List;

public interface AdminService {
    AdminDto queryAdminDto(CommonRequest commonRequest);

    Long login(LoginRequest request) throws Exception;

    Boolean updatePassword(Long adminId,String oldPassword, String newPassword, String new2Password) throws Exception;

    List<AdminEntity> queryLike(String param);
}
