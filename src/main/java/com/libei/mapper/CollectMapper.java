package com.libei.mapper;

import com.libei.entity.CollectEntity;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CollectMapper extends Mapper<CollectEntity> {

   // List<CollectEntity> queryAll();

    List<CollectEntity> queryByUserId(Long userId);

    Boolean deleteByProId(Long productId);
}
