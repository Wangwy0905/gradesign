package com.libei.mapper;


import com.libei.entity.AdminEntity;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AdminMapper extends Mapper<AdminEntity> {
    public  Integer  totalNum();
    public List<AdminEntity> queryAll(@Param(value = "page") int page, @Param(value = "rows") int rows);
}
