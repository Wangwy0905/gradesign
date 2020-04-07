package com.libei.service;

import com.libei.Dto.OrderDto;
import com.libei.controller.request.OrderAddRequest;
import com.libei.entity.OrderEntity;

import java.util.List;

public interface OrderService {
    List<OrderDto> query();

    Boolean delete(Long id);

    Boolean add(OrderAddRequest request);


    List<OrderEntity> queryFront(Long userId);
}
