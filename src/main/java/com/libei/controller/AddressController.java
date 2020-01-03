package com.libei.controller;

import com.libei.Dto.AddressDto;
import com.libei.controller.request.AddressRequest;
import com.libei.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("address")
public class AddressController {
    @Autowired
    private AddressService addressService = null;

    @CrossOrigin
    @GetMapping("add")
    public Boolean add(@RequestBody AddressRequest request) {

        return addressService.add(request);
    }

    @CrossOrigin
    @GetMapping("query") //参数只需要userId  isDefault
    public List<AddressDto> query(@RequestBody AddressRequest request ) {

        return addressService.query(request);
    }

}
