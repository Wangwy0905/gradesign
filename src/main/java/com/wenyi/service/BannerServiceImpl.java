package com.wenyi.service;

import com.wenyi.Dto.BannerDto;
import com.wenyi.entity.Banner;
import com.wenyi.mapper.BannerMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BannerServiceImpl implements  BannerService {
    @Autowired
    BannerMapper bannerMapper;

    @Override
    public List<Banner> queryAll() {
        List<Banner> banners = bannerMapper.queryAllBanner();

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
    public void insert(Banner banner) {

    }

    @Override
    public void deleteBanner(Integer id) {

    }
}
