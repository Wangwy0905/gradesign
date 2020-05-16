package com.libei.service.impl;

import com.libei.Dto.*;
import com.libei.controller.request.OrderAddRequest;
import com.libei.entity.*;
import com.libei.mapper.*;
import com.libei.service.AddressService;
import com.libei.service.ProductService;
import com.libei.service.ShopCarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

import static javax.swing.text.html.CSS.getAttribute;

@Service
@Slf4j
public class ShopCarServiceImpl implements ShopCarService {

    private Map<Long, Cartitem> productHashMap = new HashMap<>(); //定义全局map集合
    private Double totalPrice = 0.0;
    @Autowired
    private ProductService productService = null;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public Boolean addCar(Long id, Integer count) {
        ProductEntity productEntity = productService.queryOne(id);

        //HashMap<Long, Cartitem> productHashMap = (HashMap<Long, Cartitem>) session.getAttribute("productHashMap");

      /*  if (productHashMap == null) {
            productHashMap = new HashMap<>();

            Cartitem cartitem = new Cartitem(productEntity, count, productEntity.getPrice() * count);
            productHashMap.put(id, cartitem);
        }*/
        if (!productHashMap.containsKey(id)) {
            Cartitem cartitem = new Cartitem(productEntity, count, productEntity.getPrice() * count);
            productHashMap.put(id, cartitem);
        } else {
            Cartitem cartitem = productHashMap.get(id);
            cartitem.setEntity(productEntity);
            cartitem.setCount(cartitem.getCount() + count);
            cartitem.setPrice(cartitem.getPrice() + productEntity.getPrice() * count);
            productHashMap.put(id, cartitem);
        }

        return true;
    }

    @Override
    public ShopCarSum queryCar() {

        List<ShopCarDto> list = new ArrayList<>();
        ShopCarSum shopCarSum = new ShopCarSum();
        Integer count = 0;
        Double price = 0.0;
        if (productHashMap == null) {
            return null;
        } else {
            for (Long l : productHashMap.keySet()) {
                ShopCarDto shopCarDto = new ShopCarDto();
                shopCarDto.setCount(productHashMap.get(l).getCount());
                shopCarDto.setPrice(productHashMap.get(l).getEntity().getPrice());
                shopCarDto.setProductName(productHashMap.get(l).getEntity().getProductName());
                shopCarDto.setDescription(productHashMap.get(l).getEntity().getDescription());
                shopCarDto.setPicture(productHashMap.get(l).getEntity().getPicture());
                shopCarDto.setId(productHashMap.get(l).getEntity().getId());
                price += productHashMap.get(l).getCount() * productHashMap.get(l).getEntity().getPrice();
                count += productHashMap.get(l).getCount();
                list.add(shopCarDto);
            }
            shopCarSum.setCount(count);
            shopCarSum.setTotalPrice(price);
            shopCarSum.setList(list);
        }

        totalPrice = price;
        return shopCarSum;
    }

    //減少數量操作  刷新页面
    @Override
    public Boolean reduce(Long id) {
        // HashMap<Long, Cartitem> productHashMap = (HashMap<Long, Cartitem>) session.getAttribute("productHashMap");
        Cartitem cartitem = productHashMap.get(id);
        cartitem.setCount(cartitem.getCount() - 1);
        cartitem.setPrice(cartitem.getPrice() - cartitem.getEntity().getPrice());
        productHashMap.put(id, cartitem);

        return true;
    }

    //添加数量操作
    @Override
    public Boolean addCount(Long id) {
        //  HashMap<Long, Cartitem> productHashMap = (HashMap<Long, Cartitem>) session.getAttribute("productHashMap");

        Cartitem cartitem = productHashMap.get(id);
        cartitem.setCount(cartitem.getCount() + 1);
        cartitem.setPrice(cartitem.getPrice() + cartitem.getEntity().getPrice());
        productHashMap.put(id, cartitem);

        return true;
    }

    //删除
    @Override
    public Boolean remove(Long id) {
        // HashMap<Long, Cartitem> productHashMap = (HashMap<Long, Cartitem>) session.getAttribute("productHashMap");
        productHashMap.remove(id);
        return true;
    }

    //清空
    @Override
    public Boolean clear() {
        //  HashMap<Long, Cartitem> productHashMap = (HashMap<Long, Cartitem>) session.getAttribute("productHashMap");

        productHashMap.clear();
        return true;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public PaySuccessDto add(OrderAddRequest request) {

        //生成订单
        OrderEntity orderEntity = new OrderEntity();
        AddressEntity entity = addressMapper.selectByPrimaryKey(request.getAddressId());
        BeanUtils.copyProperties(request, orderEntity);
        orderEntity.setAddress(entity.getProvince() + entity.getCity() + entity.getDetailAddress());
        orderEntity.setCreateDate(System.currentTimeMillis());
        String orderId = UUID.randomUUID().toString().replace("-", "");
        orderEntity.setOrderId(orderId);

        if (productHashMap == null) {
            return null;
        }
        orderMapper.insert(orderEntity); //插入

        //订单项
        for (Map.Entry<Long, Cartitem> cartitemEntry : productHashMap.entrySet()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setCost(cartitemEntry.getValue().getPrice());
            orderItem.setCount(cartitemEntry.getValue().getCount());
            orderItem.setProductId(cartitemEntry.getValue().getEntity().getId());
            //UserEntity entity = userMapper.selectByPrimaryKey(request.getUserId());
            orderItem.setUserId(request.getUserId());
            orderItem.setCreateDate(System.currentTimeMillis());
            orderItem.setOrderId(orderId);

            ProductEntity productEntity = productMapper.selectByPrimaryKey(cartitemEntry.getValue().getEntity().getId());
            productEntity.setSaleCount(productEntity.getSaleCount() + 1);
            //productMapper.insert(productEntity);
            orderItemMapper.insert(orderItem);
        }
        //清空购物车
        this.clear();

        PaySuccessDto paySuccessDto = new PaySuccessDto();
        paySuccessDto.setOrderId(orderId);
        // AddressEntity entity = addressMapper.selectByPrimaryKey(request.getAddressId());
        paySuccessDto.setDetailAddress(entity.getProvince() + entity.getCity() + entity.getDetailAddress());
        paySuccessDto.setGainName(entity.getGainName());
        paySuccessDto.setPhoneNum(entity.getPhoneNum());
        paySuccessDto.setTotalPrice(totalPrice);
        return paySuccessDto;
    }
}
