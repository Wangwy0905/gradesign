package com.libei.controller;

import com.libei.Dto.AddressDto;
import com.libei.Dto.AddressResDto;
import com.libei.Dto.AppraiseResDto;
import com.libei.controller.request.AddressRequest;
import com.libei.controller.request.CommonRequest;
import com.libei.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author li bei
 * @date 2020.1.10
 */
@RestController
@RequestMapping("address")
public class AddressController {
    @Autowired
    private AddressService addressService = null;

    @CrossOrigin
    @PostMapping("add")
    public Boolean add(@RequestBody AddressRequest request) {

        return addressService.add(request);
    }

    @CrossOrigin
    @PostMapping("query-front") //参数只需要userId  isDefault  页面地址查询
    public List<AddressDto> query(@RequestBody AddressRequest request) {

        return addressService.query(request);
    }

    @CrossOrigin
    @PostMapping("delete")
    public Boolean delete(@RequestParam @Valid @NotNull Long id) throws Exception {

        return addressService.delete(id);
    }

    @CrossOrigin
    @PostMapping("update")
    public Boolean update(@RequestBody AddressRequest request) throws Exception {

        return addressService.update(request);
    }


    @CrossOrigin
    @GetMapping("query-detail")
    public AddressDto queryDetail(@RequestParam @Valid @NotNull Long id) throws Exception {

        return addressService.queryDetail(id);
    }

    @CrossOrigin
    @PostMapping("query-back")
    public AddressResDto queryBack(@RequestBody CommonRequest commonRequest) {

        return addressService.queryBack(commonRequest);
    }
}
