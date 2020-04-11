package com.libei.controller;

import com.libei.Dto.Cartitem;
import com.libei.Dto.ShopCarDto;
import com.libei.service.ShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("add-car")
    public Boolean addCar(@RequestParam("id") Long id, @RequestParam("count") Integer count) throws Exception {

        return shopCarService.addCar(id, count);
    }

    @CrossOrigin
    @PostMapping("query-car")
    public List<ShopCarDto> queryCar() throws Exception {

        return shopCarService.queryCar();
    }

    @CrossOrigin
    @GetMapping("remove")
    public Boolean remove(@RequestParam("id") Long id) throws Exception {

        return shopCarService.remove(id);
    }

    @CrossOrigin
    @GetMapping("reduce")
    public Boolean reduce(@RequestParam("id") Long id) throws Exception {

        return shopCarService.reduce(id);
    }

    @CrossOrigin
    @GetMapping("add-count")
    public Boolean addCount(@RequestParam("id") Long id) throws Exception {

        return shopCarService.addCount(id);
    }

    @CrossOrigin
    @PostMapping("clear")
    public Boolean clear() throws Exception {

        return shopCarService.clear();
    }

}
