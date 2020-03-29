package com.libei.service;

import com.libei.Dto.CollectResDto;
import com.libei.Dto.ProductDto;
import com.libei.controller.request.CollectRequest;
import com.libei.controller.request.CommonRequest;

public interface CollectService {
    CollectResDto query(CommonRequest request);

    Boolean add(CollectRequest request);

    Boolean delete(Long id);

    ProductDto queryFront(CommonRequest commonRequest);
}
