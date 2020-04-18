package com.libei.service.impl;

import com.libei.Dto.OrderDto;
import com.libei.Dto.OrderItemDetailDto;
import com.libei.controller.request.OrderAddRequest;
import com.libei.entity.*;
import com.libei.mapper.*;
import com.libei.service.OrderService;
import com.libei.util.ListUtils;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.tools.corba.se.idl.constExpr.Or;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

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
        if (CollectionUtils.isEmpty(orderEntities)){
            return null;
        }
        List<OrderDto> list=new ArrayList<>();
        for (OrderEntity orderEntity : orderEntities) {
           // AddressEntity addressEntity = addressMapper.selectByPrimaryKey(orderDto.getAddressId());
            UserEntity entity = userMapper.selectByPrimaryKey(orderEntity.getUserId());
           // orderDto.setDetailAddress(orderDto.getDetailAddress());
            OrderDto orderDto=new OrderDto();
            BeanUtils.copyProperties(orderEntity,orderDto);
            orderDto.setDetailAddress(orderEntity.getAddress());
            orderDto.setAccount(entity.getAccount());
            list.add(orderDto);
        }
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean delete(Long id) {

        OrderEntity orderEntity = orderMapper.selectByPrimaryKey(id);
        List<OrderItem> orderItems = orderItemMapper.queryByOrderId(orderEntity.getOrderId());
        if (CollectionUtils.isEmpty(orderItems)){
            for (OrderItem orderItem:orderItems){
                orderItemMapper.deleteByPrimaryKey(orderItem.getId());
            }

        }
        orderMapper.deleteByPrimaryKey(id);
        return true;
    }



    @Override
    public List<OrderItemDetailDto> queryFront(Long userId) {
        List<OrderItem> orderItems = orderItemMapper.queryAll(userId);
        List<OrderItemDetailDto> orderItemDetailDtos = ListUtils.entityListToModelList(orderItems, OrderItemDetailDto.class);
        for (OrderItemDetailDto detailDto : orderItemDetailDtos) {
            ProductEntity productEntity = productMapper.selectByPrimaryKey(detailDto.getProductId());
            detailDto.setEntity(productEntity);
        }
        return orderItemDetailDtos;
    }

    @Override
    public List<OrderItemDetailDto> queryDetails() {
        List<OrderItem> orderItems = orderItemMapper.queryDetails();

        List<OrderItemDetailDto> list=new ArrayList<>();
        for (OrderItem orderItem:orderItems){
            ProductEntity productEntity = productMapper.selectByPrimaryKey(orderItem.getProductId());
            OrderItemDetailDto orderItemDetailDto=new OrderItemDetailDto();
            UserEntity userEntity = userMapper.selectByPrimaryKey(orderItem.getUserId());
            BeanUtils.copyProperties(orderItem,orderItemDetailDto);
            orderItemDetailDto.setProductName(productEntity.getProductName());
            orderItemDetailDto.setAccount(userEntity.getAccount());

            list.add(orderItemDetailDto);
        }
        return list;
    }

    @Override
    public List<OrderDto> search(String orderId, String account) {

        orderId=null;
        UserEntity userEntity = userMapper.query(account);

        if (userEntity==null){
            return null;
        }

        List<OrderEntity> orderEntities = orderMapper.queryLike(orderId, userEntity.getId());


        List<OrderDto> list=new ArrayList<>();

        if (CollectionUtils.isEmpty(orderEntities)){
            return null;
        }
       // AddressEntity entity = addressMapper.selectByPrimaryKey(orderEntities.get(0));
        for (OrderEntity orderEntity : orderEntities){
            OrderDto orderDto=new OrderDto();
            BeanUtils.copyProperties(orderEntity,orderDto);
            orderDto.setAccount(userEntity.getAccount());
            orderDto.setDetailAddress(orderEntity.getAddress());
          /*  if (entity!=null){
                orderDto.setDetailAddress();
            }else{
                orderDto.setDetailAddress("地址已删除");
            }
*/
            list.add(orderDto);
        }
        return list;
    }

    @Override
    public List<OrderItemDetailDto> searchDetail(String account) {
        UserEntity userEntity = userMapper.query(account);
        List<OrderItem> orderItems = orderItemMapper.queryLike(userEntity.getId());
        List<OrderItemDetailDto> list=new ArrayList<>();
        for (OrderItem orderItem:orderItems){
            OrderItemDetailDto orderItemDetailDto=new OrderItemDetailDto();
            ProductEntity productEntity = productMapper.selectByPrimaryKey(orderItem.getProductId());
            BeanUtils.copyProperties(orderItem,orderItemDetailDto);
            orderItemDetailDto.setProductName(productEntity.getProductName());
            orderItemDetailDto.setAccount(userEntity.getAccount());
            list.add(orderItemDetailDto);
        }

        return list;
    }

    @Override
    public Boolean deleteItem(Long id) {
        orderItemMapper.deleteByPrimaryKey(id);

        return true;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean add(OrderAddRequest request) {
      /*  OrderEntity orderEntity = new OrderEntity();

        BeanUtils.copyProperties(request, orderEntity);
        orderEntity.setCreateDate(System.currentTimeMillis());
        String orderId = UUID.randomUUID().toString().replace("-", "");
        orderEntity.setOrderId(orderId);

        HashMap<Long, Cartitem> productHashMap = (HashMap<Long, Cartitem>) session.getAttribute("productHashMap");
        for (Map.Entry<Long, Cartitem> cartitemEntry : productHashMap.entrySet()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setCost(cartitemEntry.getValue().getPrice());
            orderItem.setCount(cartitemEntry.getValue().getCount());
            orderItem.setProductId(cartitemEntry.getValue().getEntity().getId());
            UserEntity entity = userMapper.selectByPrimaryKey(request.getUserId());
            orderItem.setAccount(entity.getAccount());

            ProductEntity productEntity = productMapper.selectByPrimaryKey(cartitemEntry.getValue().getEntity().getId());
            productEntity.setSaleCount(productEntity.getSaleCount() + 1);
            productMapper.insert(productEntity);
            orderItemMapper.insert(orderItem);
        }

        orderMapper.insert(orderEntity);

        return true;*/
        return true;
    }

}
