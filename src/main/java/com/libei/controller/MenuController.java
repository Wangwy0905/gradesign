package com.libei.controller;

import com.libei.Dto.MenuDto;
import com.libei.entity.MenuEntity;
import com.libei.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author li bei
 * @date 2019.12.28
 * 菜单接口
 */
@RestController
@RequestMapping("menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    @RequestMapping("query")
    public List<MenuDto> query(){
        List<MenuDto> menuDtoList = menuService.queryAll();

        return menuDtoList;
    }
}
