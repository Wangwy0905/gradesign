package com.libei.mapper;

import com.libei.entity.PhoneEntity;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ComputerMapper extends Mapper<PhoneEntity> {
    Integer totalNum();

    List<PhoneEntity> queryAll(@Param(value = "page") Integer pageSize, @Param(value = "rows") Integer pageNum);

}
