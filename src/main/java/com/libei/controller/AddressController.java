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
    @GetMapping("add")
    public Boolean add(@RequestBody AddressRequest request) {

        return addressService.add(request);
    }

    @CrossOrigin
    @GetMapping("query") //参数只需要userId  isDefault
    public List<AddressDto> query(@RequestBody AddressRequest request) {

        return addressService.query(request);
    }

    @CrossOrigin
    @GetMapping("delete")
    public Boolean delete(@RequestBody @Valid @NotNull Long id) throws Exception {

        return addressService.delete(id);
    }

    @CrossOrigin
    @GetMapping("update")
    public Boolean update(@RequestBody AddressRequest request) throws Exception {

        return addressService.update(request);
    }


    @CrossOrigin
    @GetMapping("query-detail")
    public AddressDto queryDetail(@RequestBody @Valid @NotNull Long id) throws Exception {

        return addressService.queryDetail(id);
    }

}
