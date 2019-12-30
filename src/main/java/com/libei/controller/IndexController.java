package com.libei.controller;

import com.libei.entity.ProductEntity;
import com.libei.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("index")
public class IndexController {
    @Autowired
    IndexService indexService;
    @RequestMapping("queryOne")

    public String  queryOne(Integer id, HttpSession session){
        ProductEntity computer = indexService.queryOne(id);
        session.setAttribute("computer",computer);
        System.out.println(computer);
        return "userJsp/ProductDetail";
    }
}
