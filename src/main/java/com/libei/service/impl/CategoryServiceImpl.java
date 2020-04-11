package com.libei.service.impl;

import com.github.pagehelper.PageHelper;
import com.libei.Dto.CategoryDto;
import com.libei.Dto.CategoryResDto;
import com.libei.controller.request.CategoryRequest;
import com.libei.controller.request.CollectRequest;
import com.libei.controller.request.CommonRequest;
import com.libei.entity.CategoryEntity;
import com.libei.entity.CollectEntity;
import com.libei.mapper.CategoryMapper;
import com.libei.mapper.ProductMapper;
import com.libei.service.CategoryService;
import com.libei.util.ListUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<CategoryDto> queryFirst() {
        return ListUtils.entityListToModelList(categoryMapper.queryFirst(), CategoryDto.class);
    }

    @Override
    public List<CategoryEntity> querySecond(Long firstId) {
        return categoryMapper.querySecond(firstId);
    }

    @Override
    public Boolean add(CategoryRequest request) {
        CategoryEntity categoryEntity = new CategoryEntity();

        BeanUtils.copyProperties(request, categoryEntity);
        categoryEntity.setCreateTime(LocalDateTime.now());
        categoryMapper.insert(categoryEntity);

        return true;
    }

    @Override
    public Boolean delete(Long id) {
        categoryMapper.deleteByPrimaryKey(id);

        //级联删除该分类下所有商品   慎用
        CategoryEntity categoryEntity = categoryMapper.selectByPrimaryKey(id);
        productMapper.deleteByCategory(id);

        return true;
    }

    @Override
    public Boolean update(CategoryRequest request) {
        CategoryEntity categoryEntity = new CategoryEntity();

        BeanUtils.copyProperties(request, categoryEntity);
        categoryEntity.setCreateTime(LocalDateTime.now());

        categoryMapper.updateByPrimaryKey(categoryEntity);

        return true;
    }

    @Override
    public List<CategoryEntity> queryBack() {

        List<CategoryEntity> categoryEntities = categoryMapper.queryAll();

        return categoryEntities;

    }


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
