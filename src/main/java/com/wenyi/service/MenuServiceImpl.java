package com.wenyi.service;

import com.wenyi.entity.Menu;
import com.wenyi.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuMapper categoryMapper;
    @Override
    public List<Menu> queryAll() {
        List<Menu> categories = categoryMapper.queryAll();

        return categories;
    }
}
