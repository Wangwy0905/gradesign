package com.libei.mapper;

import com.libei.entity.AppraiseEntity;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AppraiseMapper extends Mapper<AppraiseEntity> {
    List<AppraiseEntity> queryAll(@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);

    Integer totalNum();
}
