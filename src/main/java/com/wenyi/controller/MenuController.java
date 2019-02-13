package com.wenyi.controller;

import com.wenyi.entity.Menu;
import com.wenyi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("menu")
public class MenuController {

    @Autowired
    MenuService categoryService;

    @RequestMapping("queryAll")
    public List<Menu> queryAll(){
        List<Menu> categories = categoryService.queryAll();

        return categories;
    }
}
