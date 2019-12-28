package com.libei.controller;

import com.libei.Dto.BannerDto;
import com.libei.entity.BannerEntity;
import com.libei.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("banner")
public class BannerController {
    @Autowired
    BannerService bannerService;

    @RequestMapping("query")
    public BannerDto query(int rows, int page){
        BannerDto dto=bannerService.queryDto(rows,page);

        return dto;
    }

    @RequestMapping("queryAllBanner")
    public List<BannerEntity> queryAllBanner(){
        List<BannerEntity> banners = bannerService.queryAll();
       // System.out.println(banners);
        return banners;
    }
}
