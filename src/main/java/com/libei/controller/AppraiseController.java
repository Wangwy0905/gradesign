package com.libei.controller;

import com.libei.Dto.AppraiseResDto;
import com.libei.controller.request.AppraiseRequest;
import com.libei.controller.request.CommonRequest;
import com.libei.service.AppraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("delete")
    public Boolean delete(@RequestParam Long id) {

        return appraiseService.delete(id);
    }

    @CrossOrigin
    @PostMapping("query")
    public AppraiseResDto query(@RequestBody CommonRequest commonRequest) {

        return appraiseService.query(commonRequest);
    }

    //TODO 暂不提供修改功能  后续可添加
}
