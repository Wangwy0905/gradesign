package com.libei.controller;

import com.libei.Dto.ShopCarDto;
import com.libei.service.ShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
    @GetMapping("add-car")
    public Boolean addCar(HttpSession session, @RequestParam Long id) throws Exception {

        return shopCarService.addCar(session,id);
    }

    @CrossOrigin
    @PostMapping("query-car")
    public ShopCarDto queryCar(HttpSession session) throws Exception {

        return shopCarService.queryCar(session);
    }

    @CrossOrigin
    @GetMapping("remove")
    public Boolean remove(HttpSession session,@RequestParam Long id) throws Exception {

        return shopCarService.remove(session,id);
    }

    @CrossOrigin
    @GetMapping("reduce")
    public Boolean reduce(HttpSession session,@RequestParam Long id) throws Exception {

        return shopCarService.reduce(session,id);
    }

    @CrossOrigin
    @GetMapping("add-count")
    public Boolean addCount(HttpSession session,@RequestBody Long id) throws Exception {

        return shopCarService.addCount(session,id);
    }
    @CrossOrigin
    @PostMapping("clear")
    public Boolean clear(HttpSession session) throws Exception {

        return shopCarService.clear(session);
    }

}
