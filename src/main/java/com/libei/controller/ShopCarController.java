package com.libei.controller;

import com.libei.Dto.ShopCarDto;
import com.libei.service.ShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author li bei
 * @date 2019.1.3
 * @decription 购物车实现
 */
@RestController
@RequestMapping("shop-car")
public class ShopCarController {

    @Autowired
    ShopCarService shopCarService = null;

    @CrossOrigin
    @PostMapping("add-car")
    public Boolean addCar(@RequestBody @Valid @NotNull Long id) throws Exception {

        return shopCarService.addCar(id);
    }

    @CrossOrigin
    @PostMapping("query-car")
    public ShopCarDto queryCar() throws Exception {

        return shopCarService.queryCar();
    }

    @CrossOrigin
    @PostMapping("remove")
    public Boolean remove(@RequestBody @Valid @NotNull Long id) throws Exception {

        return shopCarService.remove(id);
    }

    @CrossOrigin
    @PostMapping("reduce")
    public Boolean reduce(@RequestBody @Valid @NotNull Long id) throws Exception {

        return shopCarService.reduce(id);
    }
    @CrossOrigin
    @PostMapping("clear")
    public Boolean clear() throws Exception {

        return shopCarService.clear();
    }

}
