package com.libei.controller;

import com.libei.Dto.AppraiseDto;
import com.libei.Dto.AppraiseResDto;
import com.libei.controller.request.AppraiseRequest;
import com.libei.controller.request.CommonRequest;
import com.libei.entity.AppraiseEntity;
import com.libei.service.AppraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *商品评价
 */
@RestController
@RequestMapping("/appraise")
public class AppraiseController {
    @Autowired
    private AppraiseService appraiseService;

    @CrossOrigin
    @PostMapping("add")
    public Boolean add(@RequestBody AppraiseRequest request) {

        return appraiseService.add(request);
    }

    @CrossOrigin
    @GetMapping("delete")
    public Boolean delete(@RequestParam Long id) {

        return appraiseService.delete(id);
    }

    @CrossOrigin
    @PostMapping("query")
    public List<AppraiseDto> query() {

        return appraiseService.query();
    }

    //TODO 暂不提供修改功能  后续可添加

    @CrossOrigin
    @GetMapping("query-like")
    public List<AppraiseDto> queryLike(@RequestParam Long userId) {

        return appraiseService.queryLike(userId);
    }
}
