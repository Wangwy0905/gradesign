package com.libei.controller;

import com.libei.Dto.OrderDto;
import com.libei.Dto.OrderItemDetailDto;
import com.libei.Dto.ShopCarDto;
import com.libei.controller.request.OrderAddRequest;
import com.libei.controller.request.OrderQueryRequest;
import com.libei.controller.request.ProductQueryRequest;
import com.libei.entity.OrderEntity;
import com.libei.service.OrderService;
import com.libei.service.ShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private ShopCarService shopCarService;

/*    @CrossOrigin
    @RequestMapping(value = "query",method = RequestMethod.POST)
    public List<OrderDto> query(@RequestBody OrderQueryRequest request) {
        Integer pageNum = request.getPageNum();
        Integer pageSize = request.getPageSize();

        return orderService.query(pageSize, pageNum);
    }*/

    //查看订单
    @CrossOrigin
    @RequestMapping(value = "query",method = RequestMethod.GET)
    public List<OrderDto> query() {

        return orderService.query();
    }


    @CrossOrigin
    @RequestMapping(value = "delete",method = RequestMethod.GET)
    public Boolean delete(@RequestParam @Valid @NotNull Long id) {
        return orderService.delete(id);
    }

    @CrossOrigin
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public Boolean add(@RequestBody OrderAddRequest request) {
        return shopCarService.add(request);
    }

    //查看我的订单详情
    @CrossOrigin
    @RequestMapping(value = "query-front",method = RequestMethod.GET)
    public List<OrderItemDetailDto> queryFront(@RequestParam Long userId) {
        return orderService.queryFront(userId);
    }

/*    @CrossOrigin
    @RequestMapping(value = "query-back",method = RequestMethod.GET)
    public List<OrderItemDetailDto> queryBack(@RequestParam Long userId) {
        return orderService.quer(userId);
    }*/
}
