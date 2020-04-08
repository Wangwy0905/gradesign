package com.libei.service.impl;

import com.libei.Dto.OrderDto;
import com.libei.controller.request.OrderAddRequest;
import com.libei.entity.OrderEntity;
import com.libei.entity.OrderItem;
import com.libei.entity.ProductEntity;
import com.libei.mapper.OrderMapper;
import com.libei.mapper.ProductMapper;
import com.libei.service.OrderService;
import com.libei.service.ProductService;
import com.libei.util.ListUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ProductMapper productMapper;

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
        //todo  status字段暫未使用  待定
        orderEntity.setStatus("0");
        orderEntity.setCreateDate(new Date());
        String replace = UUID.randomUUID().toString().replace("-", "");
        orderEntity.setOrderId(replace);

        //todo  销售排行待定
       // productMapper.addSale();

        orderMapper.insert(orderEntity);

        return true;
    }
   /* @Override
    public Boolean addOrderItem(OrderItem orderItem) {

        return true;
    }*/


    @Override
    public List<OrderEntity> queryFront(Long userId) {
       // List<OrderEntity> orderEntities = orderMapper.queryFront(userId);
        return null;
    }
}
