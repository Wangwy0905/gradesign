package com.libei.service;

import com.libei.Dto.BannerFrontDto;
import com.libei.controller.request.BannerCommitRequest;
import com.libei.entity.BannerEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BannerService {
    List<BannerFrontDto> query();

    List<BannerEntity> queryBanner();

    Boolean add(String title,MultipartFile file) throws Exception;

    Boolean delete(Long id);

    Boolean update(BannerCommitRequest request);

    BannerFrontDto queryDetail(Long id) throws Exception;

    Boolean open(Long id, Boolean status);
}
