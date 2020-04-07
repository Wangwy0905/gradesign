package com.libei.service;

import com.libei.Dto.CategoryDto;
import com.libei.Dto.CategoryResDto;
import com.libei.controller.request.CategoryRequest;
import com.libei.controller.request.CollectRequest;
import com.libei.controller.request.CommonRequest;
import com.libei.entity.CategoryEntity;

import java.util.HashMap;
import java.util.List;


public interface CategoryService {

    List<CategoryDto> queryFirst();
    List<CategoryEntity> querySecond(Long firstId);

    Boolean add(CategoryRequest request);

    Boolean delete(Long id);

    Boolean update(CategoryRequest request);

    List<CategoryEntity> queryBack();
}
