package com.libei.service;

import com.libei.Dto.AdminDto;
import com.libei.controller.LoginController.request.LoginRequest;

public interface AdminService {
    AdminDto queryAdminDto(int page, int rows);

    Boolean login(LoginRequest request);

    Boolean updatePassword(String password);
}
