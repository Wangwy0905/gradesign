package com.libei.service;

import com.libei.Dto.CollectResDto;
import com.libei.Dto.ProductDto;
import com.libei.controller.request.CollectRequest;
import com.libei.controller.request.CommonRequest;
import com.libei.entity.CollectEntity;

import java.util.List;

public interface CollectService {
    List<CollectEntity> query();

    Boolean add(CollectRequest request);

    Boolean delete(Long id);

    ProductDto queryFront(Long userId);
}
