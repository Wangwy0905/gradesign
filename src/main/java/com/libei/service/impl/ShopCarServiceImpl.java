package com.libei.service.impl;

import com.libei.Dto.Cartitem;
import com.libei.Dto.ShopCarDto;
import com.libei.entity.ProductEntity;
import com.libei.service.ProductService;
import com.libei.service.ShopCarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

import static javax.swing.text.html.CSS.getAttribute;

@Service
@Slf4j
public class ShopCarServiceImpl implements ShopCarService {

   // private HashMap<Long, Cartitem> productHashMap = new HashMap<>();
    @Autowired
    private ProductService productService = null;

    @Override
    public Boolean addCar(HttpSession session,Long id) {
        ProductEntity productEntity = productService.queryOne(id);

       HashMap<Long, Cartitem> productHashMap= (HashMap<Long, Cartitem>) session.getAttribute("productHashMap");

       if (productHashMap==null){
           productHashMap=new HashMap<>();

           Cartitem cartitem = new Cartitem(productEntity, 1, productEntity.getPrice());
           productHashMap.put(id, cartitem);

       }

        if (!productHashMap.containsKey(id)) {
            Cartitem cartitem = new Cartitem(productEntity, 1, productEntity.getPrice());
            productHashMap.put(id, cartitem);
        } else {
            Cartitem cartitem =productHashMap.get(id);
            cartitem.setEntity(productEntity);
            cartitem.setCount(cartitem.getCount() + 1);
            cartitem.setPrice(cartitem.getPrice() + productEntity.getPrice());
            productHashMap.put(id, cartitem);
        }

        return true;
    }

    @Override
    public ShopCarDto queryCar(HttpSession session) {
        Double totalPrice = 0.0;
        ShopCarDto shopCarDto = new ShopCarDto();
        HashMap<Long, Cartitem> productHashMap= (HashMap<Long, Cartitem>) session.getAttribute("productHashMap");
        if (productHashMap == null) {
            shopCarDto.setTotalPrice(totalPrice);
            shopCarDto.setProductHashMap(null);
        } else {
            for (Long l : productHashMap.keySet()) {
                totalPrice += productHashMap.get(l).getPrice();
            }
            shopCarDto.setTotalPrice(totalPrice);
            shopCarDto.setProductHashMap(productHashMap);
        }

        return shopCarDto;
    }

    //減少數量操作  刷新页面
    @Override
    public Boolean reduce(HttpSession session,Long id) {
        HashMap<Long, Cartitem> productHashMap= (HashMap<Long, Cartitem>) session.getAttribute("productHashMap");

        Cartitem cartitem = productHashMap.get(id);
        cartitem.setCount(cartitem.getCount()-1);
        cartitem.setPrice(cartitem.getPrice()-cartitem.getEntity().getPrice());
        productHashMap.put(id,cartitem);

        return true;
    }

    //添加数量操作
    @Override
    public Boolean addCount(HttpSession session,Long id) {
        HashMap<Long, Cartitem> productHashMap= (HashMap<Long, Cartitem>) session.getAttribute("productHashMap");

        Cartitem cartitem = productHashMap.get(id);
        cartitem.setCount(cartitem.getCount()+1);
        cartitem.setPrice(cartitem.getPrice()-cartitem.getEntity().getPrice());
        productHashMap.put(id,cartitem);

        return true;
    }

    @Override
    public Boolean remove(HttpSession session,Long id) {
        HashMap<Long, Cartitem> productHashMap= (HashMap<Long, Cartitem>) session.getAttribute("productHashMap");

        productHashMap.remove(id);
        return true;
    }

    @Override
    public Boolean clear(HttpSession session) {
        HashMap<Long, Cartitem> productHashMap= (HashMap<Long, Cartitem>) session.getAttribute("productHashMap");

        productHashMap.clear();
        return true;
    }


}
