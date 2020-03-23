package com.libei.service.impl;

import com.libei.Dto.BannerDto;
import com.libei.Dto.BannerFrontDto;
import com.libei.Dto.ProductDto;
import com.libei.controller.request.BannerCommitRequest;
import com.libei.controller.request.CommonRequest;
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

import java.util.Date;
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
        String param = request.getTitle();

        BannerDto dto = new BannerDto();
        if (param == null || "".equals(param)) {
            dto.setTotal(bannerMapper.queryNum());
            List<BannerFrontDto> bannerFrontDtos = ListUtils.entityListToModelList(bannerMapper.queryByPage(pageSize, pageNum), BannerFrontDto.class);
            dto.setRows(bannerFrontDtos);
        } else {
            List<BannerEntity> bannerEntityList = bannerMapper.queryLike(pageSize, pageNum, param);
            dto.setTotal(bannerEntityList.size());
            List<BannerFrontDto> bannerFrontDtos = ListUtils.entityListToModelList(bannerEntityList, BannerFrontDto.class);
            dto.setRows(bannerFrontDtos);
        }

        return dto;
    }

    @Override
    public List<BannerFrontDto> query() {
        List<BannerFrontDto> bannerFrontDtos = ListUtils.entityListToModelList(bannerMapper.query(), BannerFrontDto.class);

        return bannerFrontDtos;
    }


    @Override
    public Boolean add(String title, MultipartFile file) throws Exception {
        BannerEntity entity = new BannerEntity();
        entity.setTitle(title);

        String imgPath = productService.upload(file);
        entity.setPicture(imgPath);
        entity.setCreateTime(new Date());
        entity.setStatus(1);

        bannerMapper.insert(entity);

        return true;

    }

    @Override
    public Boolean delete(Long id) {
        BannerEntity entity = bannerMapper.selectByPrimaryKey(id);

        entity.setStatus(0);
        bannerMapper.updateByPrimaryKey(entity);
        return true;
    }

    @Override
    public Boolean update(BannerCommitRequest request) {
        BannerEntity entity = bannerMapper.selectByPrimaryKey(request.getId());
        entity.setTitle(request.getTitle());
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
