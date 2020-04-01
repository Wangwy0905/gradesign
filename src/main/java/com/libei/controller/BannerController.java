package com.libei.controller;

import com.libei.Dto.BannerDto;
import com.libei.Dto.BannerFrontDto;
import com.libei.controller.request.BannerCommitRequest;
import com.libei.controller.request.CommonRequest;
import com.libei.controller.request.OpenRequest;
import com.libei.entity.BannerEntity;
import com.libei.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
public class BannerController {
    @Autowired
    private BannerService bannerService = null;

    @CrossOrigin
    @PostMapping("query-back")
    public List<BannerEntity> queryBanner() {
        return bannerService.queryBanner();
    }

    @CrossOrigin
    @GetMapping("query-front")
    public List<BannerFrontDto> query() {
        List<BannerFrontDto> bannerFrontDtos = bannerService.query();

        return bannerFrontDtos;
    }

    @CrossOrigin
    @PostMapping("add")
    public Boolean add(@RequestParam("file") MultipartFile file, @RequestParam String title) throws Exception {
        return bannerService.add(title, file);

    }


    @CrossOrigin
    @GetMapping("delete")
    public Boolean delete(@RequestParam @Valid @NotNull Long id) throws Exception {
        return bannerService.delete(id);

    }


    @CrossOrigin
    @PostMapping("update")
    public Boolean update(@RequestBody BannerCommitRequest request) throws Exception {
        return bannerService.update(request);

    }

    @CrossOrigin
    @GetMapping("query-detail")
    public BannerFrontDto queryDetail(@RequestParam @Valid @NotNull Long id) throws Exception {
        BannerFrontDto bannerFrontDto = bannerService.queryDetail(id);
        return bannerFrontDto;
    }


    @CrossOrigin
    @PostMapping("open")
    public Boolean open(@RequestBody OpenRequest request) throws Exception {
        Boolean status = request.getStatus();
        Long id = request.getId();
        return bannerService.open(id,status);

    }
}
