package com.wenyi.service;

import com.wenyi.Dto.CategoryDto;
import com.wenyi.entity.Category;

import java.util.HashMap;
import java.util.List;


public interface CategoryService {
    public CategoryDto queryAllByPage(int page,int rows);
    public HashMap<String, List<Category>> querySecond(Integer pid1, Integer pid2, Integer pid3, Integer pid4);
    //前台分类
    public  List<Category> queryAll();
}
