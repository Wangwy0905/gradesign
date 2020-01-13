package com.libei.controller;

import com.libei.Dto.OrderDto;
import com.libei.controller.request.ProductQueryRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("order")
public class OrderController {
    @CrossOrigin
    @RequestMapping("query")
    public OrderDto query(@RequestBody ProductQueryRequest request) {
        return null;
    }

    @CrossOrigin
    @RequestMapping("delete")
    public Boolean delete(@RequestBody @Valid @NotNull Long id) {
        return null;
    }

    @CrossOrigin
    @RequestMapping("add")
    public Boolean add(@RequestBody @Valid @NotNull Long id) {
        return true;
    }

}
