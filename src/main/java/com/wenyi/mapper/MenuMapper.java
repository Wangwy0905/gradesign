package com.wenyi.mapper;

import com.wenyi.entity.Menu;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MenuMapper extends Mapper<Menu> {
    public List<Menu> queryAll();
}
