package com.libei.controller;

import com.libei.Dto.CollectDto;
import com.libei.Dto.CollectResDto;
import com.libei.Dto.ProductDto;
import com.libei.controller.request.CollectRequest;
import com.libei.controller.request.CommonRequest;
import com.libei.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/collect")
public class CollectController {

    @Autowired
    private CollectService collectService;
    @CrossOrigin
    @PostMapping("query-back")
    public CollectResDto query(@RequestBody CommonRequest  request) throws Exception {

        return collectService.query(request);
    }

    @CrossOrigin
    @PostMapping("add")
    public Boolean add(@RequestBody CollectRequest request) throws Exception {

        return collectService.add(request);
    }

    @CrossOrigin
    @PostMapping("delete")
    public Boolean delete(@RequestBody Long id) throws Exception {

        return collectService.delete(id);
    }

    @CrossOrigin
    @PostMapping("query-front")
    public ProductDto queryFront(@RequestBody CommonRequest commonRequest) throws Exception {

        return collectService.queryFront(commonRequest);
    }
}
