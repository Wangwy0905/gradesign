package com.libei.service.impl;

import com.libei.Dto.MenuDto;
import com.libei.entity.MenuEntity;
import com.libei.mapper.MenuMapper;
import com.libei.service.MenuService;
import com.libei.util.ListUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Beans;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuMapper menuMapper;

    @Override
    public List<MenuDto> queryAll() {
        List<MenuEntity> menuEntityList = menuMapper.selectAll();

        return ListUtils.entityListToModelList(menuEntityList, MenuDto.class);
    }
}
