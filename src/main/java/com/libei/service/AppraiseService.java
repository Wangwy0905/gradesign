package com.libei.service;

import com.libei.Dto.AppraiseDto;
import com.libei.Dto.AppraiseResDto;
import com.libei.controller.request.AppraiseRequest;
import com.libei.controller.request.CommonRequest;
import com.libei.entity.AppraiseEntity;

import java.util.List;

public interface AppraiseService {
    Boolean add(AppraiseRequest request);

    Boolean delete(Long id);

    List<AppraiseDto> query(Long productId);

    List<AppraiseDto> queryLike(Long userId);
}
