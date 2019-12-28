package com.libei.service.impl;

import com.libei.Dto.BannerDto;
import com.libei.entity.BannerEntity;
import com.libei.mapper.BannerMapper;
import com.libei.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    @Autowired
    BannerMapper bannerMapper;

    @Override
    public List<BannerEntity> queryAll() {
        List<BannerEntity> banners = bannerMapper.queryAllBanner();

        return banners;
    }

    @Override
    public BannerDto queryDto(int rows, int page) {
        BannerDto dto=new BannerDto();
        dto.setTotal(bannerMapper.queryNum());
        dto.setRows(bannerMapper.queryAllByPage(rows,page));
        return dto;
    }

    @Override
    public void insert(BannerEntity banner) {

    }

    @Override
    public void deleteBanner(Integer id) {

    }
}
