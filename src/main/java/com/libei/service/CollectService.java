package com.libei.service;

import com.libei.Dto.ProductDetailDto;
import com.libei.Dto.ProductDto;
import com.libei.controller.request.CollectRequest;
import com.libei.entity.CollectEntity;
import com.libei.entity.ProductEntity;

import java.util.List;

public interface CollectService {
    List<CollectEntity> query();

    Boolean add(CollectRequest request);

    Boolean delete(Long collectId);

    List<ProductDetailDto> queryFront(Long userId);
}
