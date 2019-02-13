package com.wenyi.mapper;

import com.wenyi.entity.Category;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CategoryMapper extends Mapper<Category> {
    public Integer totalNum();
    public List<Category> queryAllByPage(@Param(value="page")int page, @Param(value="rows") int rows);
    public  List<Category> querySecond(Integer pid);
}
