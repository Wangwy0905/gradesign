package com.libei.service;

import com.libei.Dto.MenuDto;
import com.libei.entity.MenuEntity;

import java.util.List;

public interface MenuService {
    List<MenuDto> queryAll();
}
