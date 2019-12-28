package com.libei.mapper;


import com.libei.entity.Admin;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AdminMapper extends Mapper<Admin> {
    public  Integer  totalNum();
    public List<Admin> queryAll(@Param(value = "page") int page, @Param(value = "rows") int rows);
}
