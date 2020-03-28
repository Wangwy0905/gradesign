package com.libei.controller;

import com.libei.controller.request.CommonRequest;
import com.libei.controller.request.LoginRequest;
import com.libei.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/collect")
public class CollectController {

    @Autowired
    private CollectService collectService;
    @CrossOrigin
    @PostMapping("query")
    public Boolean query(@RequestBody CommonRequest  request) throws Exception {

        return collectService.query(request);
    }
}
