package com.libei.service.impl;

import com.libei.Dto.Cartitem;
import com.libei.Dto.OrderDto;
import com.libei.Dto.OrderItemDetailDto;
import com.libei.controller.request.OrderAddRequest;
import com.libei.entity.*;
import com.libei.mapper.*;
import com.libei.service.OrderService;
import com.libei.service.ProductService;
import com.libei.util.ListUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<OrderDto> query() {
        List<OrderEntity> orderEntities = orderMapper.queryAll();
        List<OrderDto> orderDtos = ListUtils.entityListToModelList(orderEntities, OrderDto.class);
        for (OrderDto orderDto :orderDtos){
            AddressEntity addressEntity = addressMapper.selectByPrimaryKey(orderDto.getAddressId());
            UserEntity entity = userMapper.selectByPrimaryKey(orderDto.getUserId());

            orderDto.setDetailAddress(addressEntity.getProvince()+addressEntity.getCity()+addressEntity.getDetailAddress());
            orderDto.setAccount(entity.getAccount());
        }

        return orderDtos;
    }

    @Override
    public Boolean delete(Long id) {
        orderMapper.deleteByPrimaryKey(id);
        return true;
    }

    @Override
    public Boolean add(HttpSession session, OrderAddRequest request) {
        OrderEntity orderEntity = new OrderEntity();

        BeanUtils.copyProperties(request, orderEntity);
        orderEntity.setStatus("0");
        orderEntity.setCreateDate(LocalDateTime.now());
        String orderId = UUID.randomUUID().toString().replace("-", "");
        orderEntity.setOrderId(orderId);

        HashMap<Long, Cartitem> productHashMap= (HashMap<Long, Cartitem>) session.getAttribute("productHashMap");
        for (Map.Entry<Long,Cartitem> cartitemEntry:productHashMap.entrySet()){
            OrderItem orderItem=new OrderItem();
            orderItem.setCost(cartitemEntry.getValue().getPrice());
            orderItem.setCount(cartitemEntry.getValue().getCount());
            orderItem.setProductId(cartitemEntry.getValue().getEntity().getId());
            orderItem.setUserId(request.getUserId());

            orderItemMapper.insert(orderItem);
        }

        orderMapper.insert(orderEntity);

        //todo  销售排行待定
        // productMapper.addSale();

        return true;
    }

    @Override
    public List<OrderItemDetailDto> queryFront(Long userId) {
        List<OrderItem> orderItems = orderItemMapper.queryAll(userId);
        List<OrderItemDetailDto> orderItemDetailDtos = ListUtils.entityListToModelList(orderItems, OrderItemDetailDto.class);
        for (OrderItemDetailDto detailDto :orderItemDetailDtos){
            ProductEntity productEntity = productMapper.selectByPrimaryKey(detailDto.getProductId());
            detailDto.setEntity(productEntity);
        }

        return orderItemDetailDtos;
    }
}
