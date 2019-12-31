package com.libei.service;

import com.libei.Dto.BannerDto;
import com.libei.controller.request.BannerCommitRequest;
import com.libei.controller.request.CommonRequest;
import com.libei.entity.BannerEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BannerService {
    List<BannerEntity> query();
    BannerDto queryDto(CommonRequest request);
    Boolean add(BannerCommitRequest request, MultipartFile file) throws Exception;
    Boolean delete(Long id);
    Boolean update(BannerCommitRequest request);
    BannerEntity queryDetail(Long id) throws Exception;
}
