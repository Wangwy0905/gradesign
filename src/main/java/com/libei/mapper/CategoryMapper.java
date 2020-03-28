package com.libei.mapper;

import com.libei.entity.CategoryEntity;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CategoryMapper extends Mapper<CategoryEntity> {
    Integer totalNum();
    List<CategoryEntity> queryAllByPage(@Param(value = "page") int page, @Param(value = "rows") int rows);
    List<CategoryEntity> querySecond(Long firstId);
    //前台分类
    List<CategoryEntity> queryAll();

    List<CategoryEntity> queryFirst();

    List<CategoryEntity> queryByParam(@Param(value = "pageNum")int pageNum, @Param(value = "pageSize")int pageSize, @Param(value = "categoryName")String categoryName);
}
