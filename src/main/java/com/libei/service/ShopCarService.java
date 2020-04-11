package com.libei.service;

import com.libei.Dto.ShopCarDto;

import javax.servlet.http.HttpSession;

public interface ShopCarService {
    Boolean addCar(HttpSession session,Long id);

    ShopCarDto queryCar(HttpSession session);

    Boolean reduce(HttpSession session,Long id);

    Boolean remove(HttpSession session,Long id);

    Boolean clear(HttpSession session);

    Boolean addCount(HttpSession session,Long id);
}
