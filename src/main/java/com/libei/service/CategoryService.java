package com.libei.service;

import com.libei.Dto.CategoryDto;
import com.libei.entity.CategoryEntity;

import java.util.HashMap;
import java.util.List;


public interface CategoryService {

    List<CategoryDto> queryFirst();
    List<CategoryDto> querySecond(Long firstId);

    //List<CategoryEntity> queryAll();

}
