package com.libei.service.impl;

import com.github.pagehelper.PageHelper;
import com.libei.Dto.CollectDto;
import com.libei.Dto.CollectResDto;
import com.libei.Dto.ProductDetailDto;
import com.libei.Dto.ProductDto;
import com.libei.controller.request.CollectRequest;
import com.libei.controller.request.CommonRequest;
import com.libei.entity.CollectEntity;
import com.libei.entity.ProductEntity;
import com.libei.mapper.CollectMapper;
import com.libei.mapper.ProductMapper;
import com.libei.service.CollectService;
import com.libei.util.ListUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {

    @Autowired
    private CollectMapper collectMapper;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<CollectEntity> query() {
        List<CollectEntity> collectEntities = collectMapper.queryAll();
        return collectEntities;

    }

    @Override
    public Boolean add(CollectRequest request) {
        CollectEntity entity = new CollectEntity();

        BeanUtils.copyProperties(request, entity);
        entity.setCreateDate(LocalDateTime.now());

        collectMapper.insert(entity);

        return true;
    }

    @Override
    public Boolean delete(Long id) {
        collectMapper.deleteByPrimaryKey(id);
        return true;
    }

    @Override
    public ProductDto queryFront(Long userId) {
        List<ProductEntity> productEntities = productMapper.queryFront(userId);
        Integer count = productMapper.count(userId);

        ProductDto productDto=new ProductDto();

        List<ProductDetailDto> productDetailDtos = ListUtils.entityListToModelList(productEntities, ProductDetailDto.class);
        productDto.setRows(productDetailDtos);
        productDto.setTotal(count);

        return productDto;

    }


}
