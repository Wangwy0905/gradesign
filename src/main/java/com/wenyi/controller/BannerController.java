package com.wenyi.controller;

import com.wenyi.Dto.BannerDto;
import com.wenyi.entity.Banner;
import com.wenyi.mapper.BannerMapper;
import com.wenyi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("banner")
public class BannerController {
    @Autowired
    BannerService bannerService;

    @RequestMapping("queryDto")
    public BannerDto queryDto (int rows, int page){
        BannerDto dto=bannerService.queryDto(rows,page);

        return dto;
    }

    //前台Json
    @RequestMapping("queryAllBanner")
    public List<Banner> queryAllBanner(){
        List<Banner> banners = bannerService.queryAll();
        System.out.println(banners);
        return banners;
    }
}
