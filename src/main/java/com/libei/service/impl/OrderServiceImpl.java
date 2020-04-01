package com.libei.service.impl;

import com.libei.Dto.OrderDto;
import com.libei.controller.request.OrderAddRequest;
import com.libei.entity.OrderEntity;
import com.libei.mapper.OrderMapper;
import com.libei.service.OrderService;
import com.libei.util.ListUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<OrderDto> query() {
        List<OrderEntity> orderEntities = orderMapper.queryAll();
        List<OrderDto> orderDtos = ListUtils.entityListToModelList(orderEntities, OrderDto.class);
        return orderDtos;
    }

    @Override
    public Boolean delete(Long id) {
        orderMapper.deleteByPrimaryKey(id);
        return true;
    }

    @Override
    public Boolean add(OrderAddRequest request) {
        OrderEntity orderEntity = new OrderEntity();

        BeanUtils.copyProperties(request, orderEntity);
        //todo  ststus字段暫未使用  待定
        orderEntity.setStatus("0");
        orderEntity.setCreateDate(new Date());

        orderMapper.insert(orderEntity);

        return true;
    }
}
