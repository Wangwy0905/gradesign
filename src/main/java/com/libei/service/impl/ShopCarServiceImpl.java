package com.libei.service.impl;

import com.libei.Dto.Cartitem;
import com.libei.Dto.ProductDetailDto;
import com.libei.Dto.ShopCarDto;
import com.libei.controller.request.OrderAddRequest;
import com.libei.entity.OrderEntity;
import com.libei.entity.OrderItem;
import com.libei.entity.ProductEntity;
import com.libei.entity.UserEntity;
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
import java.util.*;

import static javax.swing.text.html.CSS.getAttribute;

@Service
@Slf4j
public class ShopCarServiceImpl implements ShopCarService {

    private Map<Long, Cartitem> productHashMap =new HashMap<>();
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
        }*/ if (!productHashMap.containsKey(id)) {
            Cartitem cartitem = new Cartitem(productEntity, count, productEntity.getPrice() * count);
            productHashMap.put(id, cartitem);
        } else {
            Cartitem cartitem = productHashMap.get(id);
            cartitem.setEntity(productEntity);
            cartitem.setCount(cartitem.getCount() + count);
            cartitem.setPrice(cartitem.getPrice() + productEntity.getPrice()*count);
            productHashMap.put(id, cartitem);
        }

        return true;
    }

    @Override
    public List<ShopCarDto> queryCar() {

        List<ShopCarDto> list=new ArrayList<>();
        if (productHashMap == null) {
          return null;
        } else {
            for (Long l : productHashMap.keySet()) {
                ShopCarDto shopCarDto=new ShopCarDto();
                shopCarDto.setCount(productHashMap.get(l).getCount());
                shopCarDto.setPrice(productHashMap.get(l).getPrice());
                shopCarDto.setProductName(productHashMap.get(l).getEntity().getProductName());
                shopCarDto.setDescription(productHashMap.get(l).getEntity().getDescription());
                shopCarDto.setPicture(productHashMap.get(l).getEntity().getPicture());
                shopCarDto.setId(productHashMap.get(l).getEntity().getId());

                list.add(shopCarDto);
            }
        }
        return list;
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
        cartitem.setPrice(cartitem.getPrice() - cartitem.getEntity().getPrice());
        productHashMap.put(id, cartitem);

        return true;
    }

    @Override
    public Boolean remove(Long id) {
       // HashMap<Long, Cartitem> productHashMap = (HashMap<Long, Cartitem>) session.getAttribute("productHashMap");

        productHashMap.remove(id);
        return true;
    }

    @Override
    public Boolean clear() {
      //  HashMap<Long, Cartitem> productHashMap = (HashMap<Long, Cartitem>) session.getAttribute("productHashMap");

        productHashMap.clear();
        return true;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean add(OrderAddRequest request) {
        OrderEntity orderEntity = new OrderEntity();

        BeanUtils.copyProperties(request, orderEntity);
        orderEntity.setCreateDate(System.currentTimeMillis());
        String orderId = UUID.randomUUID().toString().replace("-", "");
        orderEntity.setOrderId(orderId);

        if (productHashMap==null){
            return null;
        }

        orderMapper.insert(orderEntity);

        for (Map.Entry<Long, Cartitem> cartitemEntry : productHashMap.entrySet()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setCost(cartitemEntry.getValue().getPrice());
            orderItem.setCount(cartitemEntry.getValue().getCount());
            orderItem.setProductId(cartitemEntry.getValue().getEntity().getId());
            UserEntity entity = userMapper.selectByPrimaryKey(request.getUserId());
            orderItem.setAccount(entity.getAccount());
            orderItem.setCreateDate(System.currentTimeMillis());
            orderItem.setOrderId(orderId);

            ProductEntity productEntity = productMapper.selectByPrimaryKey(cartitemEntry.getValue().getEntity().getId());
            productEntity.setSaleCount(productEntity.getSaleCount() + 1);
            //productMapper.insert(productEntity);
            orderItemMapper.insert(orderItem);
        }



        return true;
    }



}
