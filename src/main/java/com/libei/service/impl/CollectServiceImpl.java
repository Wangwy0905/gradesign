package com.libei.service.impl;

import com.libei.Dto.ProductDetailDto;
import com.libei.Dto.ProductDto;
import com.libei.controller.request.CollectRequest;
import com.libei.entity.CollectEntity;
import com.libei.entity.ProductEntity;
import com.libei.mapper.CollectMapper;
import com.libei.mapper.ProductMapper;
import com.libei.service.CollectService;
import com.libei.util.ListUtils;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        entity.setCreateDate(System.currentTimeMillis());

        collectMapper.insert(entity);

        return true;
    }

    @Override
    public Boolean delete(Long collectId) {
        collectMapper.deleteByPrimaryKey(collectId);
        return true;
    }

    @Override
    public List<ProductDetailDto> queryFront(Long userId) {
        List<CollectEntity> collectEntities = collectMapper.queryByUserId(userId);

        List<ProductDetailDto> productDetailDtoList = new ArrayList<>();
        for (CollectEntity entity : collectEntities) {
            ProductEntity productEntity = productMapper.queryFront(entity.getProductId());
            ProductDetailDto productDetailDto = new ProductDetailDto();
            if (productEntity != null) {
                BeanUtils.copyProperties(productEntity, productDetailDto);
                productDetailDto.setCollectId(entity.getId());
                productDetailDtoList.add(productDetailDto);
            }
        }
        System.out.println(collectEntities);
        return productDetailDtoList;

    }
}
