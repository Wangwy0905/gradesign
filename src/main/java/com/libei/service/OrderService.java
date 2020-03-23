package com.libei.service;

import com.libei.Dto.OrderDto;
import com.libei.controller.request.OrderAddRequest;

import java.util.List;

public interface OrderService {
    List<OrderDto> query(Integer pageSize, Integer pageNum);

    Boolean delete(Long id);

    Boolean add(OrderAddRequest request);
}
