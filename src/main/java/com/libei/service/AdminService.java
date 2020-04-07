package com.libei.service;

import com.libei.Dto.AdminDto;
import com.libei.controller.request.AdminRequest;
import com.libei.controller.request.CommonRequest;
import com.libei.controller.request.LoginRequest;
import com.libei.entity.AddressEntity;
import com.libei.entity.AdminEntity;

import java.util.List;

public interface AdminService {
    AdminDto queryAdminDto(CommonRequest commonRequest);

    Boolean login(LoginRequest request) throws Exception;

    Boolean updatePassword(AdminRequest adminRequest) throws Exception;

    List<AdminEntity> queryLike(String param);
}
