package com.libei.mapper;


import com.libei.entity.AdminEntity;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AdminMapper extends Mapper<AdminEntity> {
    Integer totalNum();

    List<AdminEntity> queryAll(@Param(value = "pageNum") int pageNum, @Param(value = "pageSize") int pagesize);
}
