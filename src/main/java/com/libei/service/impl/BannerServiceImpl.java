package com.libei.service.impl;

import com.libei.Dto.BannerDto;
import com.libei.Dto.ProductDto;
import com.libei.controller.request.BannerCommitRequest;
import com.libei.controller.request.CommonRequest;
import com.libei.entity.BannerEntity;
import com.libei.mapper.BannerMapper;
import com.libei.service.BannerService;
import com.libei.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    @Autowired
    BannerMapper bannerMapper = null;
    @Autowired
    ProductService productService = null;

    @Override
    public BannerDto queryDto(CommonRequest request) {
        int pageNum = request.getPageNum();
        int pageSize = request.getPageSize();
        String param = request.getName();

        BannerDto dto = new BannerDto();
        if (param == null || "".equals(param)) {
            dto.setTotal(bannerMapper.queryNum());
            dto.setRows(bannerMapper.queryByPage(pageSize, pageNum));
        } else {
            List<BannerEntity> bannerEntityList = bannerMapper.queryLike(pageSize, pageNum, param);
            dto.setTotal(bannerEntityList.size());
            dto.setRows(bannerEntityList);
        }

        return dto;
    }

    @Override
    public List<BannerEntity> query() {
        List<BannerEntity> bannerEntityList = bannerMapper.query();

        return bannerEntityList;
    }


    @Override
    public Boolean add(BannerCommitRequest request, MultipartFile file) throws Exception {
        BannerEntity entity = new BannerEntity();
        BeanUtils.copyProperties(entity, request);

        String imgPath = productService.upload(file);
        entity.setPicture(imgPath);
        entity.setStatus(1);

        bannerMapper.insert(entity);

        return true;

    }

    @Override
    public Boolean delete(Long id) {
        BannerEntity entity = bannerMapper.selectByPrimaryKey(id);

        entity.setStatus(0);

        bannerMapper.insert(entity);

        return true;
    }

    @Override
    public Boolean update(BannerCommitRequest request) {
        BannerEntity entity = new BannerEntity();
        BeanUtils.copyProperties(entity, request);

        bannerMapper.insert(entity);

        return true;
    }

    @Override
    public BannerEntity queryDetail(Long id) throws Exception {
        BannerEntity entity = bannerMapper.selectByPrimaryKey(id);

        if (entity == null) {
            throw new Exception("该轮播图不存在，请检查数据");
        }

        return entity;
    }

}
