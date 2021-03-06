package com.libei.mapper;

import com.libei.entity.OrderItem;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface OrderItemMapper extends Mapper<OrderItem> {
    List<OrderItem> queryAll(Long userId);

    List<OrderItem> queryDetails();

    List<OrderItem> queryLike(Long id);

    List<OrderItem> queryByOrderId(String orderId);
}
