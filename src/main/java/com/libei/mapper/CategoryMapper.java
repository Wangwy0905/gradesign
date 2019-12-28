package com.libei.mapper;

import com.libei.entity.CategoryEntity;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CategoryMapper extends Mapper<CategoryEntity> {
    public Integer totalNum();
    public List<CategoryEntity> queryAllByPage(@Param(value="page")int page, @Param(value="rows") int rows);
    public  List<CategoryEntity> querySecond(Integer pid);

    //前台分类
    public  List<CategoryEntity> queryAll();
}
