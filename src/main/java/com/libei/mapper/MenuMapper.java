package com.libei.mapper;

import com.libei.entity.MenuEntity;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MenuMapper extends Mapper<MenuEntity> {

    List<MenuEntity> queryMenu();
}
