package com.libei.service.impl;

import com.libei.Dto.CategoryDto;
import com.libei.entity.CategoryEntity;
import com.libei.mapper.CategoryMapper;
import com.libei.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<CategoryDto> queryFirst() {
        return null;
    }

    @Override
    public List<CategoryDto> querySecond(Long firstId) {
        return null;
    }
//    @Autowired
//    CategoryMapper categoryMapper;
//    @Override
//    public CategoryDto query() {
//        List<CategoryEntity> categories = categoryMapper.queryAllByPage(page, rows);
//        Integer integer = categoryMapper.totalNum();
//        CategoryDto categoryDto=new CategoryDto();
////        categoryDto.setTotal(integer);
////        categoryDto.setRows(categories);
//
//        return  categoryDto;
//    }

//    //查询二级标题
//    @Override
//    public HashMap<String, List<CategoryEntity>> querySecond(Integer pid1, Integer pid2, Integer pid3, Integer pid4) {
//        HashMap<String, List<CategoryEntity>> map = new HashMap<>();
//        List<CategoryEntity> categories1 = categoryMapper.querySecond(pid1);
//        List<CategoryEntity> categories2 = categoryMapper.querySecond(pid2);
//        List<CategoryEntity> categories3 = categoryMapper.querySecond(pid3);
//        List<CategoryEntity> categories4 = categoryMapper.querySecond(pid4);
//
//        map.put("list1",categories1);
//        map.put("list2",categories2);
//        map.put("list3",categories3);
//        map.put("list4",categories4);
//
//        return map;
//
//    }
//
//    @Override
//    public List<CategoryEntity> queryAll() {
//        //前台分类
//            List<CategoryEntity> categories = categoryMapper.queryAll();
//
//            return  categories;
//
//    }
}