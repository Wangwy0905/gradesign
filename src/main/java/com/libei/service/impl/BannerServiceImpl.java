package com.libei.service.impl;

import com.libei.Dto.BannerFrontDto;
import com.libei.controller.request.BannerCommitRequest;
import com.libei.entity.BannerEntity;
import com.libei.mapper.BannerMapper;
import com.libei.service.BannerService;
import com.libei.service.ProductService;
import com.libei.util.ListUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    @Autowired
    BannerMapper bannerMapper = null;
    @Autowired
    ProductService productService = null;
    @Override
    public List<BannerEntity> queryBanner() {

           return bannerMapper.query();
    }


    @Override
    public List<BannerFrontDto> query() {
        List<BannerFrontDto> bannerFrontDtos = ListUtils.entityListToModelList(bannerMapper.query(), BannerFrontDto.class);

        return bannerFrontDtos;
    }


    @Override
    public Boolean add(String title, MultipartFile file, HttpServletRequest request) throws Exception {
        BannerEntity entity = new BannerEntity();
        entity.setTitle(title);

        String imgPath = productService.upload(file,request);
        entity.setPicture(imgPath);
        entity.setCreateTime(System.currentTimeMillis());
        entity.setStatus(true);

        bannerMapper.insert(entity);

        return true;

    }

    @Override
    public Boolean delete(Long id) {
        bannerMapper.deleteByPrimaryKey(id);
        return true;
    }

    @Override
    public Boolean open(Long id,Boolean status) {
        BannerEntity bannerEntity = bannerMapper.selectByPrimaryKey(id);

        bannerEntity.setStatus(status);

        bannerMapper.updateByPrimaryKey(bannerEntity);

        return true;
    }

    @Override
    public Boolean update(BannerCommitRequest request) {
        BannerEntity entity = bannerMapper.selectByPrimaryKey(request.getId());
        entity.setTitle(request.getTitle());
        entity.setCreateTime(System.currentTimeMillis());
        bannerMapper.updateByPrimaryKey(entity);
        return true;
    }

    @Override
    public BannerFrontDto queryDetail(Long id) throws Exception {
        BannerEntity entity = bannerMapper.selectByPrimaryKey(id);

        if (entity == null) {
            throw new Exception("该轮播图不存在，请检查数据");
        }
        BannerFrontDto bannerFrontDto=new BannerFrontDto();
        BeanUtils.copyProperties(entity,bannerFrontDto);
        return bannerFrontDto;
    }

}
