package com.wenyi.service;

import com.wenyi.Dto.AdminDto;
import com.wenyi.entity.Admin;

import java.util.List;

public interface AdminService {
    public AdminDto queryAdminDto(int page,int rows);
}
