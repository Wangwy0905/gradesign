package com.libei.controller;

import com.libei.Dto.ProductDto;
import com.libei.controller.request.CollectRequest;
import com.libei.entity.CollectEntity;
import com.libei.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("add")
    public Boolean add(@RequestBody CollectRequest request) throws Exception {

        return collectService.add(request);
    }

    //取消收藏
    @CrossOrigin
    @PostMapping("delete")
    public Boolean delete(@RequestBody Long id) throws Exception {

        return collectService.delete(id);
    }

    @CrossOrigin
    @GetMapping("query-front")
    public ProductDto queryFront(@RequestParam Long userId) throws Exception {

        return collectService.queryFront(userId);
    }

}
