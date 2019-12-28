package com.libei.controller.backController;

import com.libei.Dto.ComputerDto;
import com.libei.controller.backController.request.PhoneCommitRequest;
import com.libei.controller.backController.request.PhoneQueryRequest;
import com.libei.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Author  libei
 * @date 2019.12.28
 */
@RestController
@RequestMapping("phone-back")
public class PhoneController {
    @Autowired
    PhoneService phoneService;

    @CrossOrigin
    @RequestMapping("query-all")
    public ComputerDto queryAll(@RequestBody PhoneQueryRequest request) {

        Integer pageNum = request.getPageNum();
        Integer pageSize = request.getPageSize();
        ComputerDto computerDto = phoneService.queryAll(pageNum, pageSize);
        return computerDto;
    }

    @CrossOrigin
    @PostMapping("add-phone")
    public Boolean addPhone(@RequestBody PhoneCommitRequest request, MultipartFile file) throws IOException {
        return phoneService.addPhone(request);
    }

    @CrossOrigin
    @PostMapping("delete")
    public Boolean delete(@RequestParam Integer id) throws IOException {
        return phoneService.delete(id);
    }

    @CrossOrigin
    @PostMapping("update")
    public Boolean update(@RequestBody PhoneCommitRequest request) throws IOException {
        return phoneService.update(request);
    }

    @CrossOrigin
    @PostMapping("query-one")
    public Boolean queryOne(@RequestBody PhoneQueryRequest request ) throws IOException {
        return phoneService.queryOne(request);
    }

}
