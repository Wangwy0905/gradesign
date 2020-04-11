package com.libei.mapper;

import com.libei.entity.CategoryEntity;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CategoryMapper extends Mapper<CategoryEntity> {
    List<CategoryEntity> querySecond(Long firstId);
    //前台分类
    List<CategoryEntity> queryAll();

    List<CategoryEntity> queryFirst();
}
