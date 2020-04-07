package com.libei.mapper;

import com.libei.entity.OrderEntity;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface OrderMapper extends Mapper<OrderEntity> {
    List<OrderEntity> queryAll();

    void deleteByUserId(Long userId);

    List<OrderEntity> queryFront(Long userId);
}
