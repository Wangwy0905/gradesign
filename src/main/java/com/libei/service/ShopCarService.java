package com.libei.service;

import com.libei.Dto.ShopCarDto;

public interface ShopCarService {
    Boolean addCar(Long id);

    ShopCarDto queryCar();

    Boolean reduce(Long id);

    Boolean remove(Long id);

    Boolean clear();
}
