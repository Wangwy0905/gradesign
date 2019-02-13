package com.wenyi.service;

import com.wenyi.Dto.BannerDto;
import com.wenyi.entity.Banner;

import java.util.List;

public interface BannerService {
    List<Banner> queryAll();
    BannerDto queryDto(int rows, int page);
    void insert(Banner banner);
    void deleteBanner(Integer id);
    //void updateBanner(Banner banner);
}
