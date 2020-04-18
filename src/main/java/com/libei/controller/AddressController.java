package com.libei.controller;

import com.libei.Dto.AddressDto;
import com.libei.controller.request.AddressRequest;
import com.libei.entity.AddressEntity;
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

    @CrossOrigin  //解决跨域
    @PostMapping("add")
    public Boolean add(@RequestBody AddressRequest request) {

        return addressService.add(request);
    }

    @CrossOrigin
    @GetMapping("query-front") //参数只需要userId  isDefault  页面地址查询
    public List<AddressDto> query(@RequestParam("userId")Long userId) {

        return addressService.query(userId);
    }

    @CrossOrigin
    @GetMapping("delete")
    public Boolean delete(@RequestParam @Valid @NotNull Long id) throws Exception {

        return addressService.delete(id);
    }

    @CrossOrigin
    @PostMapping("update")
    public Boolean update(@RequestBody AddressRequest request) throws Exception {

        return addressService.update(request);
    }

    //修改默认
    @CrossOrigin
    @GetMapping("update-status")
    public Boolean updateStatus(@RequestParam("addressId")Long addressId,@RequestParam("isDefault") Boolean isDefault,@RequestParam("userId") Long userId) throws Exception {

        return addressService.updateStatus(addressId,isDefault,userId);
    }


    @CrossOrigin
    @GetMapping("query-detail")
    public AddressDto queryDetail(@RequestParam @Valid @NotNull Long id) throws Exception {

        return addressService.queryDetail(id);
    }

    @CrossOrigin
    @PostMapping("query-back")
    public List<AddressDto> queryBack() {
        return addressService.queryBack();
    }

    @CrossOrigin
    @GetMapping("query-like")
    public List<AddressEntity> queryLike(@RequestParam("account") String account) {

        return addressService.queryLike(account);
    }
}
