package com.libei.service;

import com.libei.Dto.BannerDto;
import com.libei.entity.BannerEntity;

import java.util.List;

public interface BannerService {
    List<BannerEntity> queryAll();
    BannerDto queryDto(int rows, int page);
    void insert(BannerEntity banner);
    void deleteBanner(Integer id);
    //void updateBanner(BannerEntity banner);
}
