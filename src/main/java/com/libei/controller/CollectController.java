package com.libei.controller;

import com.libei.Dto.ProductDetailDto;
import com.libei.controller.request.CollectRequest;
import com.libei.entity.CollectEntity;
import com.libei.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 收藏
 */
@RestController
@RequestMapping("/collect")
public class CollectController {

    @Autowired
    private CollectService collectService;

    @CrossOrigin
    @PostMapping("query-back")
    public List<CollectEntity> query() throws Exception {

        return collectService.query();
    }

    @CrossOrigin
    @PostMapping("add")
    public Boolean add(@RequestBody CollectRequest request) throws Exception {

        return collectService.add(request);
    }

    //取消收藏
    @CrossOrigin
    @GetMapping("delete")
    public Boolean delete(@RequestParam Long collectId) throws Exception {

        return collectService.delete(collectId);
    }

    @CrossOrigin
    @GetMapping("query-front")
    public List<ProductDetailDto> queryFront(@RequestParam Long userId) throws Exception {

        return collectService.queryFront(userId);
    }

}
