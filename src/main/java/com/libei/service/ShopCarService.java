package com.libei.service;

import com.libei.Dto.ShopCarDto;
import com.libei.controller.request.OrderAddRequest;

import java.util.List;

public interface ShopCarService {
    Boolean addCar(Long id,Integer count);

    List<ShopCarDto> queryCar();

    Boolean reduce(Long id);

    Boolean remove(Long id);

    Boolean clear();

    Boolean addCount(Long id);

    Boolean add(OrderAddRequest request);

}
