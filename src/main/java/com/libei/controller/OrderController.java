package com.libei.controller;

import com.libei.Dto.OrderDto;
import com.libei.controller.request.OrderAddRequest;
import com.libei.controller.request.OrderQueryRequest;
import com.libei.controller.request.ProductQueryRequest;
import com.libei.entity.OrderEntity;
import com.libei.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

/*    @CrossOrigin
    @RequestMapping(value = "query",method = RequestMethod.POST)
    public List<OrderDto> query(@RequestBody OrderQueryRequest request) {
        Integer pageNum = request.getPageNum();
        Integer pageSize = request.getPageSize();

        return orderService.query(pageSize, pageNum);
    }*/

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
        return orderService.add(request);
    }


    @CrossOrigin
    @RequestMapping(value = "query-front",method = RequestMethod.GET)
    public List<OrderEntity> queryFront(@RequestParam Long userId) {
        return orderService.queryFront(userId);
    }

}
