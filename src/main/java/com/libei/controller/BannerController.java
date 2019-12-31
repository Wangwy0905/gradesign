package com.libei.controller;

import com.libei.Dto.BannerDto;
import com.libei.controller.request.BannerCommitRequest;
import com.libei.controller.request.CommonRequest;
import com.libei.entity.BannerEntity;
import com.libei.service.BannerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author li bei
 * @description 轮播图相关接口
 * @date 2019.12.31
 */
@RestController
@RequestMapping("banner")
@Api(value = "轮播图相关Api接口", tags = {"轮播图相关Api接口"})
public class BannerController {
    @Autowired
    BannerService bannerService;

    @CrossOrigin
    @GetMapping("query-back")
    public BannerDto query(@RequestBody CommonRequest request) {
        BannerDto dto = bannerService.queryDto(request);

        return dto;
    }

    @CrossOrigin
    @GetMapping("query-front")
    public List<BannerEntity> query() {
        List<BannerEntity> bannerEntityList = bannerService.query();
        return bannerEntityList;
    }

    @CrossOrigin
    @PostMapping("add")
    public Boolean add(@RequestBody BannerCommitRequest request, MultipartFile file) throws Exception {
        return bannerService.add(request, file);

    }


    @CrossOrigin
    @PostMapping("delete")
    public Boolean delete(@RequestBody @Valid @NotNull Long id) throws Exception {
        return bannerService.delete(id);

    }


    @CrossOrigin
    @PostMapping("update")
    public Boolean update(@RequestBody BannerCommitRequest request) throws Exception {
        return bannerService.update(request);

    }

    @CrossOrigin
    @GetMapping("query-detail")
    public BannerEntity queryDetail(@RequestBody @Valid @NotNull Long id) throws Exception {
        BannerEntity bannerEntity = bannerService.queryDetail(id);
        return bannerEntity;
    }
}
