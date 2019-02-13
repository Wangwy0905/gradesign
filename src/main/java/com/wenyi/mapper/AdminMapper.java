package com.wenyi.mapper;


import com.wenyi.entity.Admin;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AdminMapper extends Mapper<Admin> {
    public  Integer  totalNum();
    public List<Admin> queryAll(@Param(value = "page") int page, @Param(value = "rows") int rows);
}
