package com.libei.service.impl;

import com.libei.Dto.ShopCarDto;
import com.libei.entity.ProductEntity;
import com.libei.service.ProductService;
import com.libei.service.ShopCarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Set;

@Service
@Slf4j
public class ShopCarServiceImpl implements ShopCarService {

    private HashMap<ProductEntity, Double> productHashMap = new HashMap<>();
    @Autowired
    private ProductService productService = null;

    @Override
    public Boolean addCar(Long id) {

        ProductEntity productEntity = productService.queryOne(id);

        if (!productHashMap.containsKey(productEntity)) {
            productHashMap.put(productEntity, productEntity.getPrice());
        } else {
            Double price = productHashMap.get(productEntity);
            productHashMap.put(productEntity, price + productEntity.getPrice());
        }


        return true;
    }

    @Override
    public ShopCarDto queryCar() {
        ShopCarDto shopCarDto = new ShopCarDto();
        shopCarDto.setProductHashMap(productHashMap);

        Double totalNum = 0.0;
        Set<ProductEntity> productEntitySet = productHashMap.keySet();
        for (ProductEntity product : productEntitySet) {
            Double price = product.getPrice();
            totalNum = totalNum + price;
        }

        shopCarDto.setTotalNum(totalNum);

        return shopCarDto;
    }

    @Override
    public Boolean reduce(Long id) {
        ProductEntity productEntity = productService.queryOne(id);
        Double totalNum = productHashMap.get(productEntity);
        productHashMap.put(productEntity, totalNum - productEntity.getPrice());
        return true;
    }

    @Override
    public Boolean remove(Long id) {
        ProductEntity productEntity = productService.queryOne(id);
        productHashMap.remove(productEntity);
        return true;
    }

    @Override
    public Boolean clear() {
        productHashMap.clear();

        return true;
    }


}
