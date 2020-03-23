package com.libei.controller;

import com.libei.Dto.OrderDto;
import com.libei.controller.request.OrderAddRequest;
import com.libei.controller.request.OrderQueryRequest;
import com.libei.controller.request.ProductQueryRequest;
import com.libei.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @CrossOrigin
    @RequestMapping("query")
    public List<OrderDto> query(@RequestBody OrderQueryRequest request) {
        Integer pageNum = request.getPageNum();
        Integer pageSize = request.getPageSize();

        return orderService.query(pageSize, pageNum);
    }

    @CrossOrigin
    @RequestMapping("delete")
    public Boolean delete(@RequestBody @Valid @NotNull Long id) {
        return orderService.delete(id);
    }

    @CrossOrigin
    @RequestMapping("add")
    public Boolean add(@RequestBody OrderAddRequest request) {
        return orderService.add(request);
    }

}
